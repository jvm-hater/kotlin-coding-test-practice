import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val input = br.readLine().toInt()
    card2(input)
    bw.flush()
    bw.close()

}
fun card2(number: Int){
    val deque = ArrayDeque((1..number).toList())
    var count = 0
    while (count<number-1){
        deque.removeFirst()
        deque.addLast(deque.removeFirst())
        count++
    }
    bw.write(deque[0].toString())
}