rootProject.name = "hello-kotlin-wasm"

include("app")

include("wasi")
project(":wasi").projectDir = file("kowasm/wasi")
