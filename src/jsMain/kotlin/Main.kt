@file:OptIn(ExperimentalTime::class)

import kotlinx.browser.document
import kotlinx.dom.appendText
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun main() {
    val time = measureTime {
        repeat(10) {
            fib(40)
        }
    }

    document.body?.appendText("took: $time")
}