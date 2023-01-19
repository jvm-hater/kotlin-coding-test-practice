import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    var answer = Int.MAX_VALUE
    for (i in 0..n / 5) {
        val temp = n - 5 * i

        if (temp % 2 == 0) {
            answer = answer.coerceAtMost(i + temp / 2)
        }
    }
    if (answer == Int.MAX_VALUE) {
        answer = -1
    }

    writer.write("${answer}\n")
    writer.flush()
    writer.close()
    reader.close()
}
