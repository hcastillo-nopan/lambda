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
        languageVersion = JavaLanguageVersion.of(file(".java-version").readText(Charsets.UTF_8))
    }
}
