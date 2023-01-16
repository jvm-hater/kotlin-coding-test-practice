import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val m = reader.readLine().toInt()
    val n = reader.readLine().toInt()

    val primes = makePrimes(n)
    val result = (m..n).toList().filter { primes[it] }

    val sum = result.sum()

    if (sum == 0) {
        writer.write("-1\n")
    } else {
        val min = result.min()
        writer.write("$sum\n")
        writer.write("$min\n")
    }

    writer.flush()
    writer.close()
    reader.close()
}

fun makePrimes(size: Int): Array<Boolean> {
    val primes = Array(size + 1) { true }
    primes[0] = false
    primes[1] = false

    for (i in 2..sqrt(primes.size.toDouble()).toInt()) {
        for (j in i * i until primes.size step i) {
            if (primes[j]) {
                primes[j] = false
            }
        }
    }
    return primes
}
