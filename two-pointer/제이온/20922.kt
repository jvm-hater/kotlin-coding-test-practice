import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val inputs = reader.readLine().split(" ").map { it.toInt() }
    val n = inputs[0]
    val k = inputs[1]
    val arr = reader.readLine().split(" ").map { it.toInt() }

    var start = 0
    var end = 0
    var count = 0
    var answer = Int.MIN_VALUE

    val map = mutableMapOf<Int, Int>()
    while (start < n) {
        while (end < n) {
            val value = map.getOrDefault(arr[end], 0)
            if (value >= k) {
                break
            }
            map[arr[end++]] = value + 1
            count++
        }
        answer = answer.coerceAtLeast(count--)
        map[arr[start]] = map[arr[start]]!! - 1
        start++
    }

    writer.write("$answer\n")
    writer.flush()
    writer.close()
    reader.close()
}
