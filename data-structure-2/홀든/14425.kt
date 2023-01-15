package 자료구조2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ")
    val stringSet = HashSet<String>()
    for (i in 0 until input[0].toInt()){
        stringSet.add(br.readLine())
    }
    var answer = 0
    for (i in 0 until input[1].toInt()){
        if (stringSet.contains(br.readLine())){
            answer++
        }
    }
    bw.write(answer.toString())
    bw.flush()
}
