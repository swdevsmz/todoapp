# ---------------------------
# EC2
# ---------------------------
# Amazon Linux 2 の最新版AMIを取得
data "aws_ssm_parameter" "amzn2_latest_ami" {
  name = "/aws/service/ami-amazon-linux-latest/amzn2-ami-hvm-x86_64-gp2"
}

# キーペア
# 変数で指定した値を設定
resource "aws_key_pair" "main" {
  key_name   = var.key_name
  public_key = file("${var.key_name}.pub")
}


resource "aws_instance" "amazonlinux" {
  for_each = var.subnets.public_subnets

  subnet_id              = aws_subnet.public[each.key].id
  ami                    = data.aws_ssm_parameter.amzn2_latest_ami.value
  instance_type          = "t2.nano"
  vpc_security_group_ids = [aws_security_group.ssh.id]

  key_name = aws_key_pair.main.key_name


  user_data = <<-EOF
#!/bin/bash
# To connect to your EC2 instance and install the Apache web server with PHP
yum update -y
yum install -y httpd php8.1
systemctl enable httpd.service
systemctl start httpd
cd /var/www/html
wget  https://us-west-2-tcprod.s3.amazonaws.com/courses/ILT-TF-200-ARCHIT/v7.7.11.prod-feed4ba8/lab-2-VPC/scripts/instanceData.zip
unzip instanceData.zip
              EOF
  tags = {
    Name = var.name
  }

  depends_on = [aws_subnet.public]
}