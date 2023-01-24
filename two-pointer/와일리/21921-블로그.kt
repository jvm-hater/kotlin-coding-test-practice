fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val x = br.readLine().split(" ")[1].toInt()
    val input = br.readLine().split(" ").map { it.toLong() }
    val arr = Array(input.size + 1) { 0L }
    for (i in 1 .. input.size) {
        arr[i] = input[i - 1] + arr[i - 1]
    }

    var l = 1
    var r = x
    var max = 0L
    var cnt = 0L

    while(r < arr.size) {
        val sum = arr[r] - arr[l - 1]

        if(sum == max) {
            cnt += 1
        } else if(sum > max) {
            max = sum
            cnt = 1
        }
        l += 1
        r += 1
    }

    if(max == 0L) {
        bw.write("SAD")
    } else {
        bw.write("$max\n")
        bw.write("$cnt\n")

    }
    bw.flush()
    bw.close()
}
