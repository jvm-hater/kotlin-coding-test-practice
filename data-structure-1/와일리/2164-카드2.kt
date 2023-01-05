fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val deque = ArrayDeque<Int>()

    repeat(n) {
        deque.addLast(it + 1)
    }

    while(deque.size > 1) {
        deque.removeFirst()
        val cur = deque.removeFirst()
        deque.addLast(cur)
    }

    bw.write("${deque[0]}")

    bw.flush()
}
