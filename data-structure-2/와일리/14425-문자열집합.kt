fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val input = br.readLine().split(" ")
    val n = input[0].toInt()
    val m = input[1].toInt()
    val set = HashSet<String>()

    repeat(n) {
        val str = br.readLine()
        set.add(str)
    }

    var ans = 0
    repeat(m) {
        val str = br.readLine()
        if(set.contains(str)) {
            ans += 1
        }
    }

    bw.write("$ans")
    bw.flush()
}
