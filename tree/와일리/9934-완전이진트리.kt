fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val inputs = br.readLine().split(" ")
    val ans = Array(n) { mutableListOf<String>() }

    search(inputs, ans, n, 0, inputs.size, 0)

    val sb = StringBuilder()
    for(i in ans) {
        for(j in i) {
            sb.append(j).append(" ")
        }
        sb.append("\n")
    }
    
    bw.write(sb.toString())
    bw.flush()
}

fun search(inputs: List<String>, ans: Array<MutableList<String>>, n: Int, start: Int, end: Int, floor: Int) {
    if(floor == n) {
        return
    }

    val mid = (start + end) / 2
    ans[floor].add(inputs[mid])

    search(inputs, ans, n, start,mid - 1, floor + 1)
    search(inputs, ans, n, mid + 1, end, floor + 1)
}
