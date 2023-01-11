import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val inputs = reader.readLine().split(" ")
    val n = inputs[0].toInt()
    val m = inputs[1].toInt()

    val strings = mutableSetOf<String>()
    for (i in 1..n) {
        strings.add(reader.readLine())
    }

    var answer = 0
    for (i in 1..m) {
        val input = reader.readLine()

        if (strings.contains(input)) {
            answer++
        }
    }

    writer.write("$answer\n")
    writer.flush()
    writer.close()
    reader.close()
}
