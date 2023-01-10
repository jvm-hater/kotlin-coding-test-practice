import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    var testCaseCount = reader.readLine().toInt()
    while (testCaseCount-- > 0) {
        val inputs = reader.readLine().split(" ")
        val n = inputs[0].toInt()
        val m = inputs[1].toInt()
        var priorities = reader.readLine().split(" ").map { it.toInt() }

        val documents = ArrayDeque((0 until n).map {
            Document("id-$it", priorities[it], it == m)
        })
        priorities = priorities.sortedDescending()

        var priorityIndex = 0
        var answer = 0
        while(!documents.isEmpty()) {
            val document = documents.removeFirst()
            if (priorities[priorityIndex] == document.priority) {
                priorityIndex++
                answer++
                if (document.selected) {
                    break
                }
                continue
            }
            documents.add(document)
        }
        writer.write("$answer\n")
    }

    writer.flush()
    writer.close()
    reader.close()
}

data class Document(val id: String, val priority: Int, val selected: Boolean)
