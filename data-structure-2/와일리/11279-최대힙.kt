fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val input = br.readLine().split(" ")
    val n = input[0].toInt()
    val pq = PriorityQueue<Long>(Collections.reverseOrder())

    repeat(n) {
        val num = br.readLine().toLong()

        if(num == 0L) {
            if(pq.isEmpty()) {
                bw.write("0\n")
            } else {
                bw.write("${pq.remove()}\n")
            }
        } else {
            pq.add(num)
        }
    }

    bw.flush()
}
