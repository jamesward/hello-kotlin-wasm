import org.kowasm.wasi.DescriptorFlags
import org.kowasm.wasi.OpenFlags
import org.kowasm.wasi.StandardDescriptor
import org.kowasm.wasi.Wasi

fun main() {
    Wasi.out.println("hello, world")

    Wasi.out.println("\n== Filesystem ==")
    Wasi.createDirectoryAt("testDir")
    val descriptor = Wasi.openAt("testFile",
        OpenFlags(create = true),
        DescriptorFlags(read = true, write = true)
    )
    val content = "Hello, file!"
    Wasi.write(descriptor, content.encodeToByteArray())
    val readResult = Wasi.read(descriptor, content.length.toULong())
    Wasi.out.println(readResult.data.decodeToString())
    Wasi.readDirectory(".", StandardDescriptor.FIRST_PREOPEN).forEach { Wasi.out.println(it) }
}
