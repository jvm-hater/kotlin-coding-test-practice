import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.TreeSet
import kotlin.text.StringBuilder

const val INF = 987654321

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val dp = Array(n + 1) { -1 }
    recur(dp, n)

    print("${if (dp[n] > INF) -1 else dp[n]}\n")
    writer.flush()
    writer.close()
    reader.close()
}

fun recur(dp: Array<Int>, n: Int): Int {
    if (n == 0) {
        return 0
    }
    if (n < 0) {
        return INF
    }

    if (dp[n] != -1) {
        return dp[n]
    }

    dp[n] = 1 + recur(dp, n - 3).coerceAtMost(recur(dp, n - 5))
    return dp[n]
}
