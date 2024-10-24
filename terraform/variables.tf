variable "name" {
  type    = string
  default = "main"
}

variable "vpc_cidr" {
  default = "10.1.0.0/16"
}

variable "subnets" {
  type = map(any)
  default = {
    private_subnets = {
      private-1a = {
        name = "private-1a",
        cidr = "10.1.10.0/24",
        az   = "ap-northeast-1a"
      },
      private-1c = {
        name = "private-1c",
        cidr = "10.1.11.0/24",
        az   = "ap-northeast-1c"
      },
      private-1d = {
        name = "private-1d",
        cidr = "10.1.12.0/24",
        az   = "ap-northeast-1d"
      },
    },
    public_subnets = {
      public-1a = {
        name = "public-1a"
        cidr = "10.1.100.0/24"
        az   = "ap-northeast-1a"
      },
      public-1c = {
        name = "public-1c"
        cidr = "10.1.101.0/24"
        az   = "ap-northeast-1c"
      },
      public-1d = {
        name = "public-1d"
        cidr = "10.1.102.0/24"
        az   = "ap-northeast-1d"
      }
    }
  }
}

# 鍵の名前
# 秘密鍵のファイル名に相当する名前
variable "key_name" {
  type    = string
  default = "ec2_key"
}