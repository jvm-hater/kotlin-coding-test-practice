import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val expected = mutableListOf<Int>()
    for (i in 1..n) {
        expected.add(reader.readLine().toInt())
    }

    val stack = ArrayDeque<Int>()
    val stringBuilder = StringBuilder()

    var expectedIndex = 1
    for (i in 1..n) {
        stack.addLast(i)
        stringBuilder.append("+\n")

        while (!stack.isEmpty() && stack[stack.size - 1] == expected[expectedIndex - 1]) {
            stack.removeLast()
            stringBuilder.append("-\n")
            expectedIndex++
        }
    }

    if (!stack.isEmpty()) {
        stringBuilder.clear()
        stringBuilder.append("NO\n")
    }

    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}
