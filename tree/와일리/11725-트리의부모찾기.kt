fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    
    val n = br.readLine().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visit = Array(n + 1) { false }
    val queue = LinkedList<Int>()
    val ans = Array(n + 1) { 0 }

    repeat(n - 1) {
        val input = br.readLine().split(" ")
        graph[input[0].toInt()].add(input[1].toInt())
        graph[input[1].toInt()].add(input[0].toInt())
    }

    queue.add(1)
    visit[1] = true
    while(queue.isNotEmpty()) {
        val parent = queue.poll()

        graph[parent].forEach { child ->
            if(!visit[child]) {
                queue.add(child)
                ans[child] = parent
                visit[child] = true
            }
        }
    }

    for(i in 2 until ans.size) {
        bw.write("${ans[i]}\n")
    }
    bw.flush()
}
