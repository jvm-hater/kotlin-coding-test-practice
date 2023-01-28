import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val people = reader.readLine().toInt()
    val t = reader.readLine().toInt()
    val findSlogan = reader.readLine().toInt()

    var person = 0
    var order = 0
    val slogans = makeSlogans()
    for (slogan in slogans) {
        if (person == people) {
            person = 0
        }
        if (slogan == findSlogan) {
            order++

            if (t == order) {
                break
            }
        }
        person++
    }

    writer.write("$person\n")
    writer.flush()
    writer.close()
    reader.close()
}

fun makeSlogans(): List<Int> {
    val slogans = mutableListOf<Int>()

    for (i in 1..100) {
        val stringBuilder = StringBuilder("0101")
        stringBuilder.append("0".repeat(i + 1))
        stringBuilder.append("1".repeat(i + 1))
        slogans.addAll(stringBuilder.toString().split("").filter { it != "" }.map { it.toInt() })
    }
    return slogans
}
