plugins {
    kotlin("multiplatform") version "1.9.0-Beta"
}

repositories {
    mavenCentral()
}

kotlin {
    @Suppress("OPT_IN_USAGE")
    wasm {
        binaries.executable()
        browser()
    }
}
