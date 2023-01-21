fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val arr = mutableListOf<Int>()
    repeat(n) {
        val num = br.readLine().toInt()
        arr.add(num)
    }

    arr.sortDescending()
    var ans = 0L
    for(i in arr.indices) {
        val tip = arr[i] - i
        if(tip > 0) {
            ans += tip
        }
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
}
