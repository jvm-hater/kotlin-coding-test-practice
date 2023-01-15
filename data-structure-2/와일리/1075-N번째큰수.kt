fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val arr = mutableListOf<Int>()
    repeat(n) {
        val input = br.readLine().split(" ")
        input.forEach { arr.add(it.toInt()) }
    }

    arr.sortDescending()
    bw.write("${arr[n - 1]}")
    bw.flush()
}
