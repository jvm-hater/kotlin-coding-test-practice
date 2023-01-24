import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 답 본 문제
// 해설: 조합 공식을 통해, 다리가 겹치는 경우를 제외한 모든 경우의 수를 알 수 있다.
// 팩토리얼 메모이제이션이 필요
val dp = Array(31) { IntArray(31) { 0 } }

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toInt()

    for (i in 0 until input) {
        val bridgeCase = br.readLine().split(" ")
        val n = bridgeCase[0].toInt()
        val r = bridgeCase[1].toInt()
        bw.write(findBridgeCase(r,n).toString()+"\n")

    }

    bw.flush()
}

fun findBridgeCase(n: Int, r: Int): Int {
    if (dp[n][r] > 0) {
        return dp[n][r]
    }
    else if (n == r || r == 0) {
        dp[n][r] =1
        return dp[n][r]
    }
    dp[n][r] = findBridgeCase(n-1, r-1) + findBridgeCase(n-1, r)
    return dp[n][r]
}