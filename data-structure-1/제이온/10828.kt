import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val deque = ArrayDeque<Int>()
    var n = reader.readLine().toInt()
    while(n-- > 0) {
        val str = reader.readLine().split(" ")
        when(str[0]) {
            "push" -> {
                val x = str[1].toInt()
                deque.addLast(x)
            }
            "pop" -> {
                if (deque.isEmpty()) {
                    writer.write("-1\n")
                } else {
                    writer.write("${deque.removeLast()}\n")
                }
            }
            "size" -> writer.write("${deque.size}\n")
            "empty" -> {
                if (deque.isEmpty()) {
                    writer.write("1\n")
                } else {
                    writer.write("0\n")
                }
            }
            "top" -> {
                if (deque.isEmpty()) {
                    writer.write("-1\n")
                } else {
                    writer.write("${deque[deque.size - 1]}\n")
                }
            }
        }
    }
    writer.flush()
    writer.close()
}
