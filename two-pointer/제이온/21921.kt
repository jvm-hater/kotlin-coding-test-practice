import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val inputs = reader.readLine().split(" ").map { it.toInt() }
    val n = inputs[0]
    val x = inputs[1]
    val visited = reader.readLine().split(" ").map { it.toInt() }

    var maxVisit = visited.slice(0 until x).sum()
    var answer = maxVisit
    var count = 1
    for (i in x until n) {
        maxVisit += visited[i] - visited[i - x]
        if (maxVisit >= answer) {
            if (maxVisit == answer) {
                count++
            } else {
                answer = maxVisit
                count = 1
            }
        }
    }

    if (answer == 0) {
        writer.write("SAD\n")
        writer.flush()
        writer.close()
        reader.close()
        return
    }

    writer.write("$answer\n")
    writer.write("$count\n")
    writer.flush()
    writer.close()
    reader.close()
}
