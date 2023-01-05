fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()

    repeat(n) {
        val input = br.readLine()
        val deque = ArrayDeque<Char>()

        for(i in input.indices) {
            val cur = input[i]

            if(cur == ')' && !deque.isEmpty()) {
                val prev = deque[deque.size - 1]
                if(prev == '(') {
                    deque.removeLast()
                }
            }else {
                deque.addLast(cur)
            }
        }

        if(deque.isEmpty()) bw.write("YES\n") else bw.write("NO\n")
    }

    bw.flush()
}
