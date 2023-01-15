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
        insertMaxHeap(br.readLine().toInt(), heap)
    }

    bw.flush()
}
fun insertMaxHeap(command: Int, heap:PriorityQueue<Int>){
    if (command == 0){
        if (heap.isEmpty()){
            bw.write(0.toString()+"\n")
        }
        else{
            bw.write(heap.remove().toString()+"\n")
        }
    }
    else{
        heap.add(command)
    }
}