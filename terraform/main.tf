terraform {
  required_version = "1.9.8"

  required_providers {
    aws = "~> 4.9"
  }
}

provider "aws" {
  region = "ap-northeast-1"
  profile = "default"

  default_tags {
    tags = {
      env = "dev"
    }
  }
}