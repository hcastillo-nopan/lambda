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
