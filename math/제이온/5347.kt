import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val stringBuilder = StringBuilder()
    for (i in 1..n) {
        val inputs = reader.readLine().split(" ").map { it.toLong() }
        val (a, b) = if (inputs[0] < inputs[1]) inputs[0] to inputs[1] else inputs[1] to inputs[0]

        stringBuilder.append(lcm(a, b)).append("\n")
    }

    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}

fun gcd(a: Long, b: Long): Long {
    if (b == 0L) {
        return a
    }
    return gcd(b, a % b)
}

fun lcm(a: Long, b: Long): Long {
    return (a * b) / gcd(a, b)
}
