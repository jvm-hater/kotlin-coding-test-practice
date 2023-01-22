import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet
import kotlin.math.sqrt
import kotlin.text.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val dp = Array(n + 1) { 0 }
    dp[1] = 1

    for (i in 2..n) {
        var min = Int.MAX_VALUE
        for (j in 1..sqrt(i.toDouble()).toInt()) {
            min = min.coerceAtMost(dp[i - j * j])
        }
        dp[i] = min + 1
    }

    writer.write("${dp[n]}\n")
    writer.flush()
    writer.close()
    reader.close()
}
