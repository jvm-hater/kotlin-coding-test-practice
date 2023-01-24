import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toInt()
    val ropeList = mutableListOf<Int>()

    for (i in 0 until input){
        ropeList.add(br.readLine().toInt())
    }
    ropeList.sortByDescending { it }
    val maxList = mutableListOf<Int>()
    for (i in 1..ropeList.size){
        maxList.add(ropeList[i-1] * i)
    }
    bw.write(maxList.maxOrNull().toString())
    bw.flush()
}