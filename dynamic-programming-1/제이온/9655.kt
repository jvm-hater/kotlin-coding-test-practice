import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.text.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    writer.write("${if (n % 2 == 0) "CY" else "SK"}\n")
    writer.flush()
    writer.close()
    reader.close()
}
