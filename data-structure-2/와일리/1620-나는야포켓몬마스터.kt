fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val input = br.readLine().split(" ")
    val n = input[0].toInt()
    val m = input[1].toInt()
    val map = HashMap<String, String>()

    repeat(n) {
        val name = br.readLine()
        val num = (it + 1).toString()
        map[name] = num
        map[num] = name
    }

    repeat(m) {
        val nameOrNum = br.readLine()
        bw.write("${map[nameOrNum]}\n")
    }

    bw.flush()
}
