var ans = Long.MIN_VALUE
val sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toLong() }
    val input = br.readLine().split(" ").map { it.toInt() }

    for(i in 1..9) {
        comb(0, i, n, input)
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
}

fun comb(cnt: Int, m: Int, n: Long, input: List<Int>) {
    if(m == cnt) {
        val num = sb.toString().toLong()
        if(n >= num) {
            ans = max(ans, num)
        }

        return
    }

    for(i in input.indices) {
        sb.append(input[i])
        comb(cnt + 1, m, n, input)
        sb.deleteAt(sb.length - 1)
    }
}
