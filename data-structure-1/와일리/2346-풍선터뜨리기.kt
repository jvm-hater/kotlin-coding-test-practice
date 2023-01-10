data class Balloon(
    val pos: Int,
    val move: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val input = br.readLine().split(" ")
    val deque = ArrayDeque<Balloon>()
    repeat(n) {
        val balloon = Balloon(it + 1, input[it].toInt())
        deque.addLast(balloon)
    }

    val sb = StringBuilder()
    while(true) {
        val balloon = deque.removeFirst()
        sb.append("${balloon.pos} ")

        if(deque.isEmpty()) break

        if(balloon.move > 0) {
            repeat(balloon.move - 1) {
                deque.addLast(deque.removeFirst())
            }
        } else {
            // 제거해야할 풍선은 덱의 맨 앞에 있기 때문에 반대로 이동할 경우 한번더 옮겨준다.
            repeat(balloon.move.absoluteValue) {
                deque.addFirst(deque.removeLast())
            }
        }
    }

    bw.write(sb.toString())
    bw.flush()
}
