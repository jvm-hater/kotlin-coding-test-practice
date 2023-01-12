import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val numbers = mutableListOf<Int>()
    for (i in 1..n) {
        numbers.addAll(reader.readLine().split(" ").map { it.toInt() })
    }
    numbers.sort()

    writer.write("${numbers[numbers.size - n]}\n")
    writer.flush()
    writer.close()
    reader.close()
}
