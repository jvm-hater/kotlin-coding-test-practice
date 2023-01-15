import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val stringBuilder = StringBuilder()

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val graph = ArrayList<ArrayList<Int>>()

    for (i in 0 until n) {
        graph.add(ArrayList())
    }

    for (i in 0 until n) {
        val inputs = reader.readLine().split(" ")
        val node = inputs[0].toCharArray()[0]
        val left = inputs[1].toCharArray()[0]
        val right = inputs[2].toCharArray()[0]

        graph[node - 'A'].add(left - 'A')
        graph[node - 'A'].add(right - 'A')
    }

    preOrderTraversal(graph, 0)
    stringBuilder.append("\n")

    inOrderTraversal(graph, 0)
    stringBuilder.append("\n")

    postOrderTraversal(graph, 0)
    stringBuilder.append("\n")

    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}

fun preOrderTraversal(graph: ArrayList<ArrayList<Int>>, root: Int) {
    val left = graph[root][0]
    val right = graph[root][1]

    stringBuilder.append('A' + root)

    if (left >= 0) {
        preOrderTraversal(graph, left)
    }

    if (right >= 0) {
        preOrderTraversal(graph, right)
    }
}

fun inOrderTraversal(graph: ArrayList<ArrayList<Int>>, root: Int) {
    val left = graph[root][0]
    val right = graph[root][1]

    if (left >= 0) {
        inOrderTraversal(graph, left)
    }

    stringBuilder.append('A' + root)

    if (right >= 0) {
        inOrderTraversal(graph, right)
    }
}

fun postOrderTraversal(graph: ArrayList<ArrayList<Int>>, root: Int) {
    val left = graph[root][0]
    val right = graph[root][1]

    if (left >= 0) {
        postOrderTraversal(graph, left)
    }

    if (right >= 0) {
        postOrderTraversal(graph, right)
    }

    stringBuilder.append('A' + root)
}
