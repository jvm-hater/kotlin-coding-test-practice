fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { mutableListOf<Char>() }
    val dna = Array(m) { Dna() }

    repeat(n) {
        val chars = br.readLine().toCharArray().toMutableList()
        arr[it].addAll(chars)
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            val cur = arr[i][j]
            dna[j].add(cur)
        }
    }

    var sum = 0
    val sb = StringBuilder()
    for (i in 0 until m) {
        sum += dna[i].min()
        sb.append(dna[i].max())
    }

    bw.write(sb.toString())
    bw.write("\n$sum")
    bw.flush()
    bw.close()
}

data class Dna(
    var a: Int = 0,
    var t: Int = 0,
    var g: Int = 0,
    var c: Int = 0
) {
    fun add(dna: Char) = when (dna) {
        'A' -> this.a += 1
        'T' -> this.t += 1
        'G' -> this.g += 1
        else -> this.c += 1
    }

    fun min(): Int {
        return when (max()) {
            'A' -> c + g + t
            'C' -> a + g + t
            'G' -> a + c + t
            else -> a + c + g
        }
    }

    fun max(): Char {
        val max = max(max(max(a, t), g), c)
        if (a == max) return 'A'
        if (c == max) return 'C'
        if (g == max) return 'G'
        return 'T'
    }
}
