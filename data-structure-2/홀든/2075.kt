package 자료구조2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Collections
import java.util.PriorityQueue

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    val heap = PriorityQueue<Int>(input.toInt(), Collections.reverseOrder())
    for (i in 0 until input.toInt()){
        val list = br.readLine().split(" ")
        heap.addAll(list.map { it.toInt() })
    }
    for (i in 1 until input.toInt()){
        heap.remove()
    }
    bw.write(heap.remove().toString())

    bw.flush()
}
