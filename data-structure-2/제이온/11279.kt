import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val queue = PriorityQueue<Int>(Collections.reverseOrder())
    var n = reader.readLine().toInt()

    val stringBuilder = StringBuffer()
    while (n-- > 0) {
        val number = reader.readLine().toInt()

        if (number == 0) {
            if (queue.isEmpty()) {
                stringBuilder.append("0\n")
            } else {
                stringBuilder.append("${queue.poll()}\n")
            }
        } else {
            queue.offer(number)
        }
    }

    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}
