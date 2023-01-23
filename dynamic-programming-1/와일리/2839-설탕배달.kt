fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    var ans = 0
    var five = n / 5
    while(true) {
        if(five < 0) {
            ans = -1
            break
        }

        val remain = n - (five * 5)
        if(remain % 3 == 0) {
            ans += (five + remain / 3)
            break
        }

        five -= 1
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
}
