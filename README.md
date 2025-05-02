# GraalVM Lambda

## Why



## How to
Package application into normal jar
```bash
 ./gradlew build -Dquarkus.package.type=legacy-jar
```
## Why Quarkus
- AWS Lambda builder out of the box.
- Compatible also with AWS API gateway.
- Spring build not natively compatible with GraalVM. A lot of tweaks needed - like manually using a Docker image builder. Dependencies are not GraalVM friendly and might need more tweaks.
- Drawback: Nopan starter will not work with Quarkus.

## TODO
- Build both examples at once?
- Example with random, fix with annotation
- Explain AOT compilation
- Deploy 2 lambdas, one jar and one native and compare
