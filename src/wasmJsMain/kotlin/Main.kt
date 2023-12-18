import kotlinx.browser.document
import kotlinx.dom.appendText

fun main() {
    document.body?.appendText("hello, world")
}
