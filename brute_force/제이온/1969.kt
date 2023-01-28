import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val dna = mutableListOf<String>()
    for (i in 1..n) {
        dna.add(reader.readLine())
    }

    var hammingDistance = 0
    val stringBuilder = StringBuilder()
    for (i in 0 until m) {
        var (a, t, g, c) = listOf(0, 0, 0, 0)

        for (j in 0 until n) {
            when(dna[j][i]) {
                'A' -> a++
                'T' -> t++
                'G' -> g++
                'C' -> c++
            }
        }

        val max = listOf(a, t, g, c).max()
        hammingDistance += n - max
        stringBuilder.append(toChar(a, t, g, c, max))
    }
    stringBuilder.append("\n").append(hammingDistance)

    writer.write(stringBuilder.toString())
    writer.flush()
    writer.close()
    reader.close()
}

fun toChar(a: Int, t: Int, g: Int, c: Int, max: Int): Char {
    return when (max) {
        a -> 'A'
        c -> 'C'
        g -> 'G'
        t -> 'T'
        else -> throw RuntimeException()
    }
}
