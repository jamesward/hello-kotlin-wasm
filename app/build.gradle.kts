import org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsExec

plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
}

kotlin {
    @Suppress("OPT_IN_USAGE")
    wasm {
        binaries.executable()
        nodejs()
        //applyBinaryen()
    }
    sourceSets {
        getByName("wasmMain") {
            dependencies {
                implementation(project(":wasi"))
            }
        }
    }
}

tasks.named("wasmNodeRun") {
    dependsOn("wasmProductionExecutableCompileSync")
}

tasks.withType<NodeJsExec> {
    nodeArgs = mutableListOf("--experimental-wasm-gc")
    sourceMapStackTraces = false
    inputFileProperty = layout.buildDirectory.file("js/packages/hello-kotlin-wasm-app-wasm/kotlin/runner.mjs")
    doFirst {
        layout.buildDirectory.dir("js/packages/hello-kotlin-wasm-app-wasm/testDir").get().asFile.delete()
    }
}
