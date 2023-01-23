import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val arr = reader.readLine().split(" ").map { it.toLong() }.sorted()

    var start = 0
    var end = n - 1

    var difference = Long.MAX_VALUE
    lateinit var answer: Pair<Long, Long>
    while (start < end) {
        val sum = arr[start] + arr[end]

        if (sum == 0L) {
            answer = Pair(arr[start], arr[end])
            break
        }

        if (difference > abs(sum)) {
            difference = abs(sum)
            answer = Pair(arr[start], arr[end])
        }
        if (sum > 0L) {
            end--
        } else {
            start++
        }
    }

    writer.write("${answer.first} ${answer.second}\n")
    writer.flush()
    writer.close()
    reader.close()
}
