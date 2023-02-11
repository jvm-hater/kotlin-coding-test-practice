fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val nArr = br.readLine().split(" ").map { it.toInt() }.sorted()
    val m = br.readLine().toInt()
    val mArr = br.readLine().split(" ").map { it.toInt() }

    for(i in 0 until m) {
        val ans = nArr.bSearch(mArr[i])
        bw.write("$ans ")
    }

    bw.flush()
    bw.close()
}

fun List<Int>.bSearch(target: Int): Int {
    var low = 0
    var high = this.lastIndex

    while (low <= high) {
        val mid = (low + high) / 2

        when {
            this[mid] < target   -> low = mid + 1
            this[mid] > target   -> high = mid - 1
            this[mid] == target  -> return 1
        }
    }

    return 0
}
