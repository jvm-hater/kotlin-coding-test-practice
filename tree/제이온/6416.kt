import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val graph = mutableMapOf<Int, Int>()
    var k = 0
    val stringBuilder = StringBuilder()
    first@while (true) {
        k++
        graph.clear()

        second@while (true) {
            val inputs = reader.readLine().split("  ")

            for (input in inputs) {
                if (input.isEmpty()) {
                    continue
                }

                val x = input.split(" ")[0].toInt()
                val y = input.split(" ")[1].toInt()

                if (x == -1 && y == -1) {
                    break@first
                }

                if (x == 0 && y == 0) {
                    break@second
                }

                graph[x] = graph.getOrDefault(x, 0)
                graph[y] = graph.getOrDefault(y, 0) + 1
            }
        }

        // 빈 트리도 트리다.
        if (graph.isEmpty()) {
            stringBuilder.append("Case $k is a tree.\n")
            continue
        }

        val rootNodes = graph.filter { it.value == 0 }.keys

        // 들어오는 간선이 하나도 없는 유일한 노드가 있어야 한다.
        if (rootNodes.size != 1) {
            stringBuilder.append("Case $k is not a tree.\n")
            continue
        }

        val rootNode = rootNodes.iterator().next()

        // 루트 노드를 제외한 나머지 간선은 모두 들어오는 유일한 간선이 있어야 한다.
        val isUniqueEdge = graph.filter { it.key != rootNode }.all { it.value == 1 }
        if (!isUniqueEdge) {
            stringBuilder.append("Case $k is not a tree.\n")
            continue
        }

        // 루트 노드에서 다른 노드로 모두 이동할 수 있어야 한다. (정점의 개수 -1) = (엣지의 개수)
        val edges = graph.values.sum()

        if (graph.size - 1 != edges) {
            stringBuilder.append("Case $k is not a tree.\n")
            continue
        }

        stringBuilder.append("Case $k is a tree.\n")
    }

    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}
