# AWS Lambda

## Context
- At some point in the future we might want to have lightweight AWS Lambdas functions for some scenarios
- A good candidate is to process a DynamoDB stream into AWS Redshift for analytics
- Normally AWS Lambdas use a lightweight runtime to save costs - we are charged by memory footprint and execution time)
- This doesn't fit very good with Java, but there is a way to improve the cost of running Java based lambdas

## GraalVM compilation
- GraalVM allows you to compile Java code into native executables - native for the environment on which you will run it
- It used AOT (ahead of time) compilation, which means that the Java code is compiled before it is run during build time

## Why Quarkus
- AWS Lambda builder out of the box - one library only
- Spring build is not natively compatible with GraalVM.
- Dependencies are also native-friendly

## Drawbacks
- GraalVM will require extra tweaks for reflection and usage of `Random`

## How to deploy
- Package application into normal jar
    ```bash
    ./gradlew build
    ```
- Package application into native image.
    ```bash
    ./gradlew nativeBuild
    ```