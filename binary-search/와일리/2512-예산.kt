fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    var arr = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()

    arr = arr.sorted()
    val ans = arr.bSearch(m)

    bw.write("$ans")
    bw.flush()
    bw.close()
}

fun List<Int>.bSearch(m: Int): Int {
    var low = 0
    var high = this.last()
    var mid = 0

    while (low <= high) {
        var sum = 0
        mid = (low + high) / 2


        for(i in this.indices) {
            sum += if(this[i] >= mid) {
                mid
            } else {
                this[i]
            }
        }

        if(sum <= m) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return low - 1
}
