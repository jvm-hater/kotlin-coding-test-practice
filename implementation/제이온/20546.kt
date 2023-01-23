import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = reader.readLine().toInt()
    val stocks = reader.readLine().split(" ").map { it.toInt() }

    var bnp = n
    var bnpCount = 0
    for (stock in stocks) {
        if (bnp < stock) {
            continue
        }

        val q = bnp / stock

        bnp -= stock * q
        bnpCount += q
        if (bnp == 0) {
            break
        }
    }
    bnp += bnpCount * stocks[stocks.size - 1]

    var timing = n
    var timingCount = 0

    var beforeStock = 0
    var upDownCount = 0
    for (stock in stocks) {
        if (beforeStock > stock) {
            if (upDownCount > 0) {
                upDownCount = 0
            }
            upDownCount--

            if (upDownCount <= -3) {
                val q = timing / stock

                timing -= stock * q
                timingCount += q
            }
        } else if (beforeStock < stock) {
            if (upDownCount < 0) {
                upDownCount = 0
            }
            upDownCount++

            if (upDownCount >= 3) {
                timing += timingCount * stock
                timingCount = 0
            }
        }
        beforeStock = stock
    }
    timing += timingCount * stocks[stocks.size - 1]

    if (bnp < timing) {
        writer.write("TIMING\n")
    } else if (bnp == timing) {
        writer.write("SAMESAME\n")
    } else {
        writer.write("BNP\n")
    }

    writer.flush()
    writer.close()
    reader.close()
}
