import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.text.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val ropes = mutableListOf<Int>()
    for (i in 1..n) {
        ropes.add(reader.readLine().toInt())
    }
    ropes.sort()

    var answer = 0
    for (i in 1..n) {
        answer = answer.coerceAtLeast(i * ropes[ropes.size - i])
    }

    writer.write("$answer\n")
    writer.flush()
    writer.close()
    reader.close()
}
