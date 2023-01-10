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

    val deque = ArrayDeque<Char>()
    var answer = 0
    var temp = 1
    for (i in brackets.indices) {
        when(brackets[i]) {
            '(' -> {
                deque.addLast('(')
                temp *= 2
            }
            '[' -> {
                deque.addLast('[')
                temp *= 3
            }
            ')' -> {
                if (deque.isEmpty() || deque[deque.size - 1] != '(') {
                    answer = 0
                    break
                }
                if (brackets[i - 1] == '(') {
                    answer += temp
                }
                temp /= 2
                deque.removeLast()
            }
            ']' -> {
                if (deque.isEmpty() || deque[deque.size - 1] != '[') {
                    answer = 0
                    break
                }
                if (brackets[i - 1] == '[') {
                    answer += temp
                }
                temp /= 3
                deque.removeLast()
            }
        }
    }

    if (!deque.isEmpty()) {
        answer = 0
    }

    writer.write("$answer\n")
    writer.flush()
    writer.close()
    reader.close()
}
