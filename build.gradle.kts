plugins {
    java
    alias(libs.plugins.graalvm.build.plugin)
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.amazon.lambda.java)
    implementation(libs.spring.cloud.function.adapter)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(file(".java-version").readText(Charsets.UTF_8))
    }
}

graalvmNative {
    binaries {
        named("main") {
            javaLauncher = javaToolchains.launcherFor {
                languageVersion = JavaLanguageVersion.of(file(".java-version").readText(Charsets.UTF_8))
            }
            imageName.set("lambda-function")
            buildArgs.add("--no-fallback")
            buildArgs.add("--enable-url-protocols=http,https")
            buildArgs.add("--install-exit-handlers")
        }
    }
}
