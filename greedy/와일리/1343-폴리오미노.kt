fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var input = br.readLine()
    val sb = StringBuilder()

    input = input.replace("XXXX", "AAAA")
    input = input.replace("XX", "BB")

    for(i in input.indices) {
        if(input[i] == 'X') {
            sb.clear()
            sb.append("-1")
            break
        }
       sb.append(input[i])
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
}
