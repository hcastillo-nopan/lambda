# GraalVM Lambda

## Why

## Why Quarkus
- AWS Lambda builder out of the box.
- Compatible also with AWS API gateway.
- Spring build not natively compatible with GraalVM. A lot of tweaks needed - like manually using a Docker image builder. Dependencies are not GraalVM friendly and might need more tweaks.
- Drawback: Nopan starter will not work with Quarkus.

## How to deploy
- Package application into normal jar
    ```bash
    ./gradlew build
    ```
- Package application into native image.
    ```bash
    ./gradlew build \
    -Dquarkus.native.enabled=true \
    -Dquarkus.package.jar.enabled=false \
    -Dquarkus.native.container-build=true \
    -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel-builder-image:jdk-21
    ```
quarkus.native.enabled,

## TODO
- Build logic to profile
- Redact Why section
- Explain AOT compilation
- Deploy 2 lambdas, one jar and one native and compare
- Example with random, fix with annotation