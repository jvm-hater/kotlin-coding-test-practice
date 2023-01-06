fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val input = br.readLine().split(" ")
    val deque = ArrayDeque<Int>()
    repeat(input[0].toInt()){
        deque.addLast(it + 1)
    }

    val k = input[1].toInt()
    var num = 1
    val ans = mutableListOf<Int>()

    while(!deque.isEmpty()) {
        if(num % k == 0) {
            ans.add(deque.removeFirst())
        } else {
            deque.addLast(deque.removeFirst())
        }
        num++
    }

    bw.write(ans.toString().replace('[', '<').replace(']', '>'))
    bw.flush()
}
