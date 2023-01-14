import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val graph = ArrayList<ArrayList<Int>>()

    for (i in 0..n) {
        graph.add(ArrayList())
    }

    for (i in 1 until n) {
        val input = reader.readLine().split(" ")
        val x = input[0].toInt()
        val y = input[1].toInt()

        graph[x].add(y)
        graph[y].add(x)
    }
    
    val parents = bfs(graph, n, 1)
    for (i in 2 until parents.size) {
        writer.write("${parents[i]}\n")
    }
    writer.flush()
    writer.close()
    reader.close()
}


fun bfs(graph: ArrayList<ArrayList<Int>>, n: Int, start: Int): Array<Int?> {
    val parents = arrayOfNulls<Int>(n + 1)

    val queue = ArrayDeque<Int>()
    queue.add(start)

    while (queue.isNotEmpty()) {
        val parent = queue.removeFirst()

        for (node in graph[parent]) {
            if (parents[node] == null) {
                parents[node] = parent
                queue.add(node)
            }
        }
    }
    return parents
}
