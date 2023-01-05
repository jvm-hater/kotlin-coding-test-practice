fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val deque = ArrayDeque<Int>()

    repeat(n) {
        val input = br.readLine().split(" ")

        when (input[0]) {
            "push" -> deque.addLast(input[1].toInt())
            "pop" -> {
                if (deque.isEmpty()) {
                    bw.write("-1\n")
                } else {
                    bw.write("${deque.removeLast()}\n")
                }
            }
            "size" -> bw.write("${deque.size}\n")
            "empty" -> {
                if (deque.isEmpty()) {
                    bw.write("1\n")
                } else {
                    bw.write("0\n")
                }
            }
            "top" -> {
                if (deque.isEmpty()) {
                    bw.write("-1\n")
                } else {
                    bw.write("${deque[deque.size - 1]}\n")
                }
            }
        }
    }

    bw.flush()
}
