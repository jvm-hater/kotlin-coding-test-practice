import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
//계속 시간 초과 발생해서 ArrayDeque로 변경하니 성공..? ArrayList보다 ArrayDeque성능이 더 빠른가..?
fun main() {


    val inputCount = br.readLine().toInt()
    val queue = ArrayDeque<Int>()
    for (i in 0 until inputCount) {
        val command = br.readLine()
        chooseQueueCommand(command, queue)
    }
    bw.flush()
    bw.close()

}

fun chooseQueueCommand(command: String, queue: ArrayDeque<Int>) {
    val commandArray = command.split(" ")
    when (commandArray[0]) {
        "push" -> {
            queue.add(commandArray[1].toInt())
        }
        "pop" -> {
            queue.pop()

        }
        "front" -> {
            queue.front()

        }
        "back" -> {
            queue.back()

        }
        "empty" -> {
            queue.empty()

        }
        "size" -> {
            bw.write("${queue.size}\n")

        }
    }
}

fun ArrayDeque<Int>.front() {
    if (this.isEmpty()) {
        bw.write("-1\n")
    } else {
        bw.write("${this[0]}\n")
    }
}

fun ArrayDeque<Int>.back() {
    if (this.isEmpty()) {
        bw.write("-1\n")
    } else {
        bw.write("${this[this.size-1]}\n")
    }
}


fun ArrayDeque<Int>.pop() {
    if (this.isEmpty()) {
        bw.write("-1\n")
    }else {
        bw.write("${removeAt(0)}\n")
    }
}

fun ArrayDeque<Int>.empty() {
    if (this.isEmpty()) {
        bw.write("1\n")
    } else {
        bw.write("0\n")
    }
}
