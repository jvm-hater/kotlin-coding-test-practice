val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {
    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    val graph1 = Array(n + 1) { PriorityQueue<Int>() }
    val graph2 = Array(n + 1) { PriorityQueue<Int>() }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph1[a].add(b)
        graph1[b].add(a)
        graph2[a].add(b)
        graph2[b].add(a)
    }

    dfs(v, graph1, Array(n + 1) { false })
    bw.write("\n")
    bfs(v, graph2, Array(n + 1) { false })

    bw.flush()
    bw.close()
}

fun dfs(v: Int, graph: Array<PriorityQueue<Int>>, visit: Array<Boolean>) {
    visit[v] = true
    bw.write("$v ")

    while(graph[v].isNotEmpty()) {
        val n = graph[v].remove()
        if(!visit[n]) {
            dfs(n, graph, visit)
        }
    }
}

fun bfs(v: Int, graph: Array<PriorityQueue<Int>>, visit: Array<Boolean>) {
    val queue = LinkedList<Int>()

    queue.add(v)
    visit[v] = true
    while(queue.isNotEmpty()) {
        val parent = queue.poll()
        bw.write("$parent ")

        while(graph[parent].isNotEmpty()) {
            val child = graph[parent].remove()
            if(!visit[child]) {
                queue.add(child)
                visit[child] = true
            }
        }
    }
}
