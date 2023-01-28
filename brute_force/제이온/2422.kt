import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val checkArray = Array(201) { Array(201) { false } }
    for (i in 1..m) {
        val (a, b) = reader.readLine().split(" ").map { it.toInt() }
        checkArray[a][b] = true
        checkArray[b][a] = true
    }

    var answer = 0
    for (i in 1..n) {
        for (j in i + 1..n) {
            if (checkArray[i][j]) {
                continue
            }
            for (k in j + 1..n) {
                if (checkArray[i][k] || checkArray[j][k]) {
                    continue
                }
                answer++
            }
        }
    }

    writer.write("$answer\n")
    writer.flush()
    writer.close()
    reader.close()
}
