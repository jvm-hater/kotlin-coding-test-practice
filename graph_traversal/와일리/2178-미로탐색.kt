fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val miro = Array(n) { mutableListOf<Int>() }
    val path = Array(n) { Array(m) { 0 } }
    val visit = Array(n) { Array(m) { false } }

    for(i in 0 until n) {
        val str = br.readLine().map { it.toString().toInt() }
        miro[i].addAll(str)
    }

    bfs(Pos(0, 0), Pos(n - 1, m - 1), miro, path, visit)
    
    bw.write("${path[n - 1][m - 1]}")
    bw.flush()
    bw.close()
}

data class Pos(val row: Int, val col: Int)

fun bfs(start: Pos, end: Pos, miro: Array<MutableList<Int>>, path: Array<Array<Int>>, visit: Array<Array<Boolean>>) {
    val queue = LinkedList<Pos>()
    val dr = arrayListOf(1, 0, -1, 0)
    val dc = arrayListOf(0, 1, 0, -1)

    path[start.row][start.col] = 1
    queue.add(start)
    visit[start.row][start.col] = true
    while(queue.isNotEmpty()) {
        val cur = queue.poll()
        for(i in 0 until 4) {
            val nextRow = cur.row + dr[i]
            val nextCol = cur.col + dc[i]

            if(nextRow < 0 || nextCol < 0 || nextRow > end.row || nextCol > end.col) continue
            if(visit[nextRow][nextCol]) continue
            if(miro[nextRow][nextCol] == 0) continue

            queue.add(Pos(nextRow, nextCol))
            visit[nextRow][nextCol] = true
            path[nextRow][nextCol] = path[cur.row][cur.col] + 1
        }
    }
}
