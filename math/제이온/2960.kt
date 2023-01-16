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

    val numbers = Array(n + 1) { true }

    var count = 0
    outer@for (i in 2..n) {
        if (numbers[i]) {
            numbers[i] = false
            count++

            if (count == k) {
                writer.write("$i\n")
                break
            }

            for (j in i..n step i) {
                if (numbers[j]) {
                    numbers[j] = false
                    count++

                    if (count == k) {
                        writer.write("$j\n")
                        break@outer
                    }
                }
            }
        }
    }

    writer.flush()
    writer.close()
    reader.close()
}
