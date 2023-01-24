fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val input = br.readLine().split(" ")
    val a = br.readLine().split(" ").map { it.toInt() }
    val b = br.readLine().split(" ").map { it.toInt() }
    val ans = mutableListOf<Int>()

    var aIdx = 0
    var bIdx = 0
    while(true) {
        if(aIdx >= a.size) {
            ans.addAll(b.subList(bIdx, b.size))
            break
        }

        if(bIdx >= b.size) {
            ans.addAll(a.subList(aIdx, a.size))
            break
        }

        if(a[aIdx] == b[bIdx]) {
            ans.add(a[aIdx])
            ans.add(b[bIdx])
            aIdx += 1
            bIdx += 1
        } else if(a[aIdx] > b[bIdx]) {
            ans.add(b[bIdx])
            bIdx += 1
        } else {
            ans.add(a[aIdx])
            aIdx += 1
        }
    }

    ans.map { bw.write("$it ") }
    bw.flush()
    bw.close()
}
