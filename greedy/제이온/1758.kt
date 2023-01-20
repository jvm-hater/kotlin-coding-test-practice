import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.text.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val people = mutableListOf<Int>()

    for (i in 1..n) {
        people.add(reader.readLine().toInt())
    }
    people.sortDescending()

    var answer = 0L
    for (i in 1.. people.size) {
        val money = people[i - 1] - (i - 1)

        if (money > 0) {
            answer += money
        }
    }

    writer.write("$answer\n")
    writer.flush()
    writer.close()
    reader.close()
}
