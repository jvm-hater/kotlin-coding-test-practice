import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    val primes = makePrimes()
    val result = numbers.count { primes[it] }

    writer.write("$result\n")
    writer.flush()
    writer.close()
    reader.close()
}

fun makePrimes(): Array<Boolean> {
    val primes = Array(1001) { true }
    primes[0] = false
    primes[1] = false

    var i = 2
    while (i * i < primes.size) {
        if (primes[i]) {
            var j = i * i
            while (j < primes.size) {
                if (primes[j]) {
                    primes[j] = false
                }
                j += i
            }
        }
        i++
    }
    return primes
}
