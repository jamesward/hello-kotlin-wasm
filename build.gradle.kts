plugins {
    kotlin("multiplatform") version "1.8.22" apply false
    id("org.jetbrains.dokka") version "1.8.20" apply false // for kowasm
}

allprojects {
    repositories {
        mavenCentral()
    }
}

// node --experimental-wasi-unstable-preview1 --experimental-wasm-gc runner.mjs
plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
        nodeVersion = "20.2.0"
        //nodeCommand = "node --experimental-wasi-unstable-preview1 --experimental-wasm-gc runner.mjs"
    }
}
