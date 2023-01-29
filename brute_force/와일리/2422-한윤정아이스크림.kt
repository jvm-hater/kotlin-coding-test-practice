fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val pairs = Array(n + 1) { Array(n + 1) { false } }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        pairs[a][b] = true;
        pairs[b][a] = true;
    }

    var sum = 0
    for (i in 1..n) {
        for (j in i + 1..n) {
            if (pairs[i][j]) continue
            for (k in j + 1..n) {
                if (!pairs[j][k] && !pairs[k][i]) {
                    sum++
                }
            }
        }
    }

    bw.write("$sum")
    bw.flush()
    bw.close()
}
