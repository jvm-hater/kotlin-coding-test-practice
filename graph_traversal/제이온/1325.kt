import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import java.util.StringTokenizer

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    var inputs = reader.readLine().split(" ").map { it.toInt() }
    val n = inputs[0]
    val m = inputs[1]

    val graph = ArrayList<ArrayList<Int>>()
    for (i in 0..n) {
        graph.add(ArrayList())
    }

    for (i in 1..m) {
        inputs = reader.readLine().split(" ").map { it.toInt() }
        val a = inputs[0]
        val b = inputs[1]

        graph[a].add(b)
    }

    val hacks = Array(n + 1) { 0 }
    var visited = Array(n + 1) { false }
    for (i in 1..n) {
        dfs(i, visited, graph, hacks)
        visited = Array(n + 1) { false }
    }

    val max = hacks.max()
    val stringBuilder = StringBuilder()
    for (i in 1..n) {
        if (hacks[i] == max) {
            stringBuilder.append(i).append(" ")
        }
    }
    stringBuilder.append("\n")

    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}

fun dfs(start: Int, visited: Array<Boolean>, graph: ArrayList<ArrayList<Int>>, hacks: Array<Int>) {
    visited[start] = true
    hacks[start]++

    for (node in graph[start]) {
        if (!visited[node]) {
            dfs(node, visited, graph, hacks)
        }
    }
