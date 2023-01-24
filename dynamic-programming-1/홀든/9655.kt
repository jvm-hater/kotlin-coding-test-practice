import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

// 답 본 문제
// n -1, n-3 으로 재귀를 해야겠다.. 정도는 생각이 나는데 그 이후로는 잘 모르겠어서 답 확인
// 해설: 돌의 개수가 홀수면 상근, 짝수면 창용이 이김(홀짝)
// DP 해설: 돌을 3개, 1개 씩 가져올 수 있고, 게임의 횟수를 DP(N)이라 했을 때,
// DP(N) = min(DP(N-1)+1, DP(N-3)+1)이다.
val dp = Array(1001) { 0 }

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toInt()
    dp[1] = 1
    dp[2] = 2
    for (i in 3..input) {
        dp[i] = min(dp[i - 1] + 1, dp[i - 3] + 1)
    }
    if (dp[input] % 2 == 1) {
        bw.write("SK")
    } else {
        bw.write("CY")
    }


    bw.flush()
}
