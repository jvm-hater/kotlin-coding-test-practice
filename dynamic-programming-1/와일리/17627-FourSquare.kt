fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val dp = Array(n + 1) { 0 }

    dp[1] = 1
    for (i in 2..n) {
        var min = Int.MAX_VALUE
        var j = 1
        while (j * j <= i) {
            min = min(min, dp[i - j * j])
            j++
        }
        dp[i] = min + 1
    }

    bw.write("${dp[n]}")
    bw.flush()
    bw.close()
}
