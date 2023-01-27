fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[b].add(a)
    }

    var max = 0
    val ans = mutableListOf<Int>()
    for(i in 1..n) {
        val cnt = bfs(i, graph, Array(n + 1) { false })

        if(max == cnt) {
            ans.add(i)
        } else if(max < cnt) {
            max = cnt
            ans.clear()
            ans.add(i)
        }
    }

    ans.forEach { bw.write("$it ") }
    bw.flush()
    bw.close()
}

fun bfs(start: Int, graph: Array<MutableList<Int>>, visit: Array<Boolean>): Int {
    val queue = LinkedList<Int>()
    var cnt = 0

    queue.add(start)
    visit[start] = true
    while(queue.isNotEmpty()) {
        val parent = queue.poll()
        cnt += 1

        graph[parent].forEach { child ->
            if(!visit[child]) {
                queue.add(child)
                visit[child] = true
            }
        }
    }

    return cnt
}
