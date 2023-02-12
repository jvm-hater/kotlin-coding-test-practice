val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
lateinit var arr: Array<Int>

fun main() {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    arr = Array(m) { 0 }

    comb(0, 1, n, m)
    bw.flush()
    bw.close()
}

fun comb(depth: Int, start: Int, n: Int, m: Int) {
    if (depth == m) {
        arr.forEach { bw.write("$it ") }
        bw.write("\n")
        return
    }

    for (i in start..n) {
        arr[depth] = i
        comb(depth + 1, i + 1, n, m)
    }
}
