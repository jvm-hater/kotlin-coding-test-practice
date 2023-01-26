fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }
    var l = 0
    var r = 0
    var max = 0
    val map = mutableMapOf<Int, Int>()

    while(true) {
        if(r >= n) {
            max = max(max, r - l)
            break
        }

        val num = arr[r]
        if(map.getOrDefault(num, 0) >= k) {
            max = max(max, r - l)
            map[arr[l]] = map[arr[l]]!! - 1
            l += 1
        } else {
            r += 1
            map[num] = map.getOrDefault(num, 0) + 1
        }
    }

    bw.write("$max")
    bw.flush()
    bw.close()
}
