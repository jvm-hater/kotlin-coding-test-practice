import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import kotlin.text.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    reader.readLine().split(" ").map { it.toInt() }
    val queue = PriorityQueue<Int>()
    for (i in 1..2) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        queue.addAll(numbers)
    }

    val stringBuilder = StringBuilder()
    while (queue.isNotEmpty()) {
        stringBuilder.append(queue.poll()).append(" ")
    }
    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}
