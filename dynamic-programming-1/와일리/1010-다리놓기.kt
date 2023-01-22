fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val dp = Array(31) { LongArray(31) }
    for (i in 1..30) {
        dp[i][1] = i.toLong()

        for (j in 2 until i) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        }

        dp[i][i] = 1
    }

    val t = br.readLine().toInt()
    repeat (t) {
        val input = br.readLine().split(" ")
        val n = input[0].toInt()
        val r = input[1].toInt()
        bw.write("${dp[r][n]}\n")
    }

    bw.flush()
    bw.close()
}
