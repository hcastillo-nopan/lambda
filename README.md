# GraalVM Lambda

## Context
- At some point in the future we might want to have lightweight AWS Lambdas functions for some scenarios: e.g. DynamoDB trigger, SNS event, scheduled job
- Normally AWS Lambdas use a lightweight runtime to save costs - we are charged by memory footprint and execution time)
- This doesn't fit very good with Java, but there is a way to improve the cost of running Java based lambdas

## GraalVM compilation
- GraalVM allows you to compile Java code into native executables - native for the environment on which you will run it
- It used AOT (ahead of time) compilation, which means that the Java code is compiled before it is run during build time

## Why Quarkus
- AWS Lambda builder out of the box.
- Compatible also with AWS API gateway - Lambda proxy integration
- Spring build not natively compatible with GraalVM. Dependencies are not native-friendly and might need more tweaks.
- Drawback: Nopan starter will not work with Quarkus.

## Drawbacks
- Nopan starter will not work with Quarkus
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