provider "aws" {
  region = "eu-west-1"
}

resource "aws_iam_role" "nopan_lambda_role" {
  name = "NopanLambdaRole"
  assume_role_policy = jsonencode({
    Version = "2012-10-17",
    Statement = [{
      Action = "sts:AssumeRole",
      Effect = "Allow",
      Principal = {
        Service = "lambda.amazonaws.com"
      },
    }],
  })
}

resource "aws_iam_role_policy_attachment" "nopan_lambda_policy_attachment" {
  role       = aws_iam_role.nopan_lambda_role.name
  policy_arn = "arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole"
}

resource "aws_lambda_function" "nopan_lambda" {
  function_name = "NopanLambda"
  role          = aws_iam_role.nopan_lambda_role.arn
  handler       = "io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler::handleRequest"
  runtime       = "java21"
  filename      = "../build/function.zip"
  source_code_hash = filebase64sha256("../build/function.zip")
  timeout = 10
}
