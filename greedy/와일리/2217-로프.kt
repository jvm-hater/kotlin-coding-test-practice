fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val ropes = mutableListOf<Int>()
    repeat(n) {
        val rope = br.readLine().toInt()
        ropes.add(rope)
    }

    ropes.sortDescending()

    var ans = 0
    for(i in 0 until ropes.size) {
        val weight = ropes[i]
        var cnt = i
        for(j in i until ropes.size) {
            if(weight > ropes[j]) {
                break
            }

            cnt += 1
        }
        ans = max(ans, weight * cnt)
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
}
