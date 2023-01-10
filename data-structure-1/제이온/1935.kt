import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val postfixNotation = reader.readLine()
    val numbers = mutableListOf<Int>()
    for (i in 1..n) {
        numbers.add(reader.readLine().toInt())
    }

    val variableOfMap = mutableMapOf<Char,Double>()
    for (i in 'A' until 'A' + n) {
        variableOfMap[i] = numbers[i - 'A'].toDouble()
    }

    val stack = ArrayDeque<Double>()
    postfixNotation.forEach {
        when (it) {
            '*' -> {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.addLast(a * b)
            }
            '/' -> {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.addLast(a / b)
            }
            '+' -> {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.addLast(a + b)
            }
            '-' -> {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.addLast(a - b)
            }
            else -> stack.addLast(variableOfMap[it]!!)
        }
    }

    val result = String.format("%.2f", stack.removeLast())
    writer.write("$result\n")
    writer.flush()
    writer.close()
    reader.close()
}
