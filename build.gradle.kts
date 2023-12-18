plugins {
    kotlin("multiplatform") version "1.9.21"
}

repositories {
    mavenCentral()
}

kotlin {
    @Suppress("OPT_IN_USAGE")
    wasmJs {
        binaries.executable()
        browser()
        applyBinaryen()
    }
}
