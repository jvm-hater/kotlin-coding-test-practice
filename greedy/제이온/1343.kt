import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.text.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val board = reader.readLine()
    val answer = StringBuilder()

    var xCount = 0
    if (board.contains('.')) {
        board.forEach {
            if (it == '.') {
                if (xCount % 2 != 0) {
                    writer.write("-1\n")
                    writer.flush()
                    writer.close()
                    reader.close()
                    return
                }

                if (xCount == 2) {
                    answer.append("BB")
                } else {
                    val a = xCount / 4
                    val b = xCount % 4 / 2

                    val result = "AAAA".repeat(a) + "BB".repeat(b)
                    answer.append(result)
                }

                answer.append('.')
                xCount = 0
            } else {
                xCount++
            }
        }
    } else {
        board.forEach { _ ->
            xCount++
        }
    }

    if (xCount % 2 != 0) {
        writer.write("-1\n")
        writer.flush()
        writer.close()
        reader.close()
        return
    }

    if (xCount == 2) {
        answer.append("BB")
    } else {
        val a = xCount / 4
        val b = xCount % 4 / 2

        val result = "AAAA".repeat(a) + "BB".repeat(b)
        answer.append(result)
    }

    writer.write(answer.toString())
    writer.flush()
    writer.close()
    reader.close()
}
