import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cash = br.readLine().toInt()
    val stockRate = br.readLine().split(" ").map { it.toInt() }
    var jCash = cash
    var sCash = cash
    var jStock = 0
    var sStock = 0
    var upRate = 0
    var downRate = 0
    stockRate.forEachIndexed { index, s ->
        if (index > 0) {
            if (stockRate[index] > stockRate[index - 1]) {
                downRate = 0
                upRate++
            }
            if (stockRate[index] < stockRate[index - 1]) {
                upRate = 0
                downRate++
            }
        }
        if (upRate == 3) {
            upRate = 0
            sCash += sStock * stockRate[index]
            sStock = 0
        }
        if (downRate == 3) {
            sStock += sCash / stockRate[index]
            sCash %= stockRate[index]
            downRate = 0
        }
        if (jCash / stockRate[index] > 0) {
            jStock += jCash / stockRate[index]
            jCash %= stockRate[index]
        }


    }
    sCash += sStock * stockRate[stockRate.lastIndex]
    jCash += jStock * stockRate[stockRate.lastIndex]
    if (sCash > jCash) {
        println("TIMING")
    } else if (jCash > sCash) {
        println("BNP")
    } else {
        println("SAMESAME")
    }
    bw.flush()
}
