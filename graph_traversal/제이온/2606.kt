import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val m = reader.readLine().toInt()

    val graph = ArrayList<ArrayList<Int>>()
    for (i in 0..n) {
        graph.add(ArrayList())
    }

    for (i in 1..m) {
        val inputs = reader.readLine().split(" ").map { it.toInt() }
        val a = inputs[0]
        val b = inputs[1]

        graph[a].add(b)
        graph[b].add(a)
    }

    val visited = Array(n + 1) { false }
    dfs(1, visited, graph)

    writer.write("${visited.count { it } - 1}\n")
    writer.flush()
    writer.close()
    reader.close()
}

fun dfs(start: Int, visited: Array<Boolean>, graph: ArrayList<ArrayList<Int>>) {
    visited[start] = true

    for (item in graph[start]) {
        if (!visited[item]) {
            dfs(item, visited, graph)
        }
    }
}
