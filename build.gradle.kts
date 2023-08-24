plugins {
    kotlin("multiplatform") version "1.9.10"
}

repositories {
    mavenCentral()
}

kotlin {
    @Suppress("OPT_IN_USAGE")
    wasm {
        binaries.executable()
        browser()
        applyBinaryen()
    }
}
