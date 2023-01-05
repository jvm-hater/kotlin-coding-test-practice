import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    var n = reader.readLine().toInt()
    outer@while(n-- > 0) {
        val input = reader.readLine()
        val deque = ArrayDeque<Char>()

        for (c in input) {
            if (c == '(') {
                deque.addFirst(c)
            } else {
                if (deque.isEmpty()) {
                    writer.write("NO\n")
                    continue@outer
                }
                deque.removeLast()
            }
        }

        if (deque.isEmpty()) {
            writer.write("YES\n")
        } else {
            writer.write("NO\n")
        }
    }

    writer.flush()
    writer.close()
}
