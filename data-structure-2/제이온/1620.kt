import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val inputs = reader.readLine().split(" ")
    val n = inputs[0].toInt()
    val m = inputs[1].toInt()

    val pokemons = hashMapOf<String, String>()
    for (i in 1..n) {
        val pokemon = reader.readLine()
        pokemons[i.toString()] = pokemon
        pokemons[pokemon] = i.toString()
    }

    val stringBuilder = StringBuilder()
    for (i in 1..m) {
        val input = reader.readLine()
        stringBuilder.append(pokemons[input]).append("\n")
    }

    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}
