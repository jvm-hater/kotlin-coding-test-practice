import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val inputCount = br.readLine().toInt()
    var count = 0
    for (i in 0 until inputCount) {
        val word = br.readLine()
        count += goodWord(word)
    }
    bw.write(count.toString())
    bw.flush()
    bw.close()

}
fun goodWord(word: String) : Int{
    val stack = Stack<String>()

    word.forEach {
        if (stack.size>0) {
            if (stack.peek() == it.toString()) {
                stack.pop()
                return@forEach
            }
        }
        stack.push(it.toString())
    }
    if (stack.isEmpty()){
        return 1
    }
    else{
        return 0
    }
}

