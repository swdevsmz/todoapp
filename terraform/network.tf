#----------------------------------------
# VPC
#----------------------------------------
resource "aws_vpc" "main" {
  cidr_block           = var.vpc_cidr
  enable_dns_support   = true # AWSのDNSサーバによる名前解決を有効
  enable_dns_hostnames = true # VPC内のリソースにパブリックDNSホスト名を自動的に割り当てる

  tags = {
    Name = var.name
  }
}

#----------------------------------------
# Internet Gateway
#----------------------------------------
resource "aws_internet_gateway" "main" {
  vpc_id = aws_vpc.main.id

  tags = {
    Name = var.name
  }
}


#----------------------------------------
# Public Subnet
#----------------------------------------
resource "aws_subnet" "public" {
  for_each = var.subnets.public_subnets

  vpc_id                  = aws_vpc.main.id
  cidr_block              = each.value.cidr
  availability_zone       = each.value.az
  map_public_ip_on_launch = true

  tags = {
    Name = "${var.name}-${each.value.name}"
  }

}

#----------------------------------------
# Route table public-subnetとigwのルート
#----------------------------------------
resource "aws_route_table" "public_route" {
  vpc_id = aws_vpc.main.id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.main.id
  }
  tags = {
    Name = var.name
  }
}

#----------------------------------------
# public SubnetとRoute tableの関連付け
#----------------------------------------
resource "aws_route_table_association" "public_route_associate" {
  for_each = var.subnets.public_subnets

  subnet_id      = aws_subnet.public[each.key].id
  route_table_id = aws_route_table.public_route.id

  depends_on = [aws_subnet.public]

}

#----------------------------------------
# Security Group for ssh
#----------------------------------------
resource "aws_security_group" "ssh" {
  description = "ssh"
  vpc_id      = aws_vpc.main.id
  tags = {
    Name = var.name
  }

  # インバウンドルール
  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # 接続元を限定する場合は変更する
  }

  # インバウンドルール
  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # 接続元を限定する場合は変更する
  }

  # インバウンドルール
  ingress {
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # 接続元を限定する場合は変更する
  }

  # アウトバウンドルール
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}