import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import kotlin.math.absoluteValue

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val brackets = reader.readLine().toCharArray()

    var bars = 0
    var answer = 0
    var index = 0

    while (index < brackets.size) {
        if (brackets[index] == '(') {
            if (index != brackets.size - 1 && brackets[index + 1] == ')') {
                answer += bars
                index++
            } else {
                bars++
            }
        } else {
            bars--
            answer++
        }
        index++
    }

    writer.write("$answer\n")
    writer.flush()
    writer.close()
    reader.close()
}
