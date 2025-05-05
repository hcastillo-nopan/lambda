plugins {
    java
    alias(libs.plugins.quarkus.plugin)
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.quarkus.lambda)

}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of("21")
    }
}

tasks.register<Exec>("nativeBuild") {
    commandLine(
        "./gradlew", "build",
        "-Dquarkus.native.enabled=true",
        "-Dquarkus.package.jar.enabled=false",
        "-Dquarkus.native.container-build=true",
        "-Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel-builder-image:jdk-21",
    )
}