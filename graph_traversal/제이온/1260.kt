import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

val stringBuilder = StringBuilder()

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    var inputs = reader.readLine().split(" ").map { it.toInt() }
    val n = inputs[0]
    val m = inputs[1]
    val v = inputs[2]

    val graph = ArrayList<ArrayList<Int>>()
    for (i in 0..n) {
        graph.add(ArrayList())
    }

    for (i in 1..m) {
        inputs = reader.readLine().split(" ").map { it.toInt() }
        val a = inputs[0]
        val b = inputs[1]

        graph[a].add(b)
        graph[b].add(a)
    }

    for (list in graph) {
        list.sort()
    }

    var visited = Array(n + 1) { false }
    dfs(v, visited, graph)
    stringBuilder.append("\n")

    visited = Array(n + 1) { false }
    bfs(v, visited, graph)
    stringBuilder.append("\n")

    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}

fun dfs(start: Int, visited: Array<Boolean>, graph: ArrayList<ArrayList<Int>>) {
    visited[start] = true
    stringBuilder.append(start).append(" ")

    for (item in graph[start]) {
        if (!visited[item]) {
            dfs(item, visited, graph)
        }
    }
}

fun bfs(start: Int, visited: Array<Boolean>, graph: ArrayList<ArrayList<Int>>) {
    val queue = ArrayDeque<Int>()
    queue.add(start)
    visited[start] = true

    while (!queue.isEmpty()) {
        val node = queue.removeFirst()
        stringBuilder.append(node).append(" ")

        for (item in graph[node]) {
            if (!visited[item]) {
                visited[item] = true
                queue.add(item)
            }
        }
    }
}
