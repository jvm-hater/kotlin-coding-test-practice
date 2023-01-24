import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var input = br.readLine()
    val filteredList = input.split(".").toMutableList().filter { it.isNotEmpty() }
    val pA = "AAAA"
    val pB = "BB"
    filteredList.forEachIndexed { index, s ->
        var replacedString = ""
        var length = s.length
        while (true) {
            if (length / 4 != 0) {
                replacedString = replacedString.plus(pA)
                length -= 4
            } else if (length / 2 != 0) {
                replacedString = replacedString.plus(pB)
                length -= 2
            }
            else{
                bw.write((-1).toString())
                bw.flush()
                return
            }
            if (replacedString.length == s.length) {
                input = input.replaceFirst(filteredList[index], replacedString)
                break
            }
        }
    }
    bw.write(input)
    bw.flush()
}