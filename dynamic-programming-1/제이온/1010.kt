import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.text.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val dp = Array(31) { IntArray(31) { 0 } }
    for (i in 1..30) {
        dp[1][i] = i
    }

    for (i in 2..30) {
        for (j in 1..30) {
            if (i == j) {
                dp[i][j] = 1
                continue
            }
            var temp = 0
            for (k in (i - 1) until j) {
                temp += dp[i - 1][k]
            }
            dp[i][j] = temp
        }
    }
    println()

    var t = reader.readLine().toInt()
    val stringBuilder = StringBuilder()
    while (t-- > 0) {
        val inputs = reader.readLine().split(" ").map { it.toInt() }
        val n = inputs[0]
        val m = inputs[1]
        stringBuilder.append(dp[n][m]).append("\n")
    }
    
    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}
