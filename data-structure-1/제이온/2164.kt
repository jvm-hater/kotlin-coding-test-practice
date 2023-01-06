import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val cards = ArrayDeque((1..n).toList())
    while(true) {
        if (cards.size == 1) {
            writer.write("${cards.removeFirst()}\n")
            break
        }
        cards.removeFirst()
        cards.add(cards.removeFirst())
    }

    writer.flush()
    writer.close()
}
