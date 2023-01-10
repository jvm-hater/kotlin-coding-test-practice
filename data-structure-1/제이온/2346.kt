import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder
import kotlin.math.absoluteValue

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val papers = reader.readLine().split(" ")
    val balloons = ArrayDeque((1..n).map {
        Balloon(it, papers[it - 1].toInt())
    })
    
    val stringBuilder = StringBuilder()
    while (true) {
        val balloon = balloons.removeFirst()
        stringBuilder.append("${balloon.number} ")

        if (balloons.isEmpty()) {
            break
        }

        if (balloon.paper > 0) {
            for (i in 1 until balloon.paper) {
                balloons.addLast(balloons.removeFirst())
            }
        } else {
            for (i in 1..balloon.paper.absoluteValue) {
                balloons.addFirst(balloons.removeLast())
            }
        }
    }
    
    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}

data class Balloon(val number: Int, val paper: Int)
