# GraalVM Lambda

## Why

- TODO

## Benefits
- AWS Lambda builder out of the box
- Compatible also with AWS API gateway

## Drawbacks
- Introducing a new framework. Why not Spring?
  - Not natively compatible with GraalVM
  - A lot of tweaks needed - like manually using a Docker image builder
  - Libraries are not GraalVM friendly
- Not compatible with Nopan starter

## TODO
- Example with random, fix with annotation
- Explain AOT compilation
- Deploy 2 lambdas, one jar and one native and compare

## Alternatives
- Spring - we can get it done with a lot of pain
- Maybe Micronaut
- No framework lambda
