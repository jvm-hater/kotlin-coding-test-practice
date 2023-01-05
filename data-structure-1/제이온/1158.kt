import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))
    val stringBuilder = StringBuilder()

    val input = reader.readLine().split(" ")
    val n = input[0].toInt()
    val k = input[1].toInt()

    var numbers = (1..n).toList()
    val deque = ArrayDeque<Int>()

    var idx = 0
    var count = 1
    stringBuilder.append("<")
    while (true) {
        if (idx == numbers.size) {
            idx = 0
            numbers = deque.toList()
            deque.clear()
        } else if (count < k) {
            deque.add(numbers[idx])
            count++
            idx++
        } else if (count == k) {
            stringBuilder.append("${numbers[idx]}, ")
            count = 1
            idx++
        }

        if (numbers.isEmpty()) {
            break
        }
    }
    stringBuilder.append(">")

    writer.write("${stringBuilder.removeRange(stringBuilder.length - 3, stringBuilder.length - 1)}\n")
    writer.flush()
    writer.close()
}
