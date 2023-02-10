@file:OptIn(ExperimentalTime::class)

import kotlinx.browser.document
import kotlinx.dom.appendText
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun main() {
    document.body?.appendText("asdf")
}