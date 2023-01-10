import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val inputCount = br.readLine().toInt()
    val queue = ArrayDeque<Int>()
    for (i in 0 until inputCount) {
        val command = br.readLine()
        chooseDequeCommand(command, queue)
    }
    bw.flush()
    bw.close()

}
fun chooseDequeCommand(command: String, deque: ArrayDeque<Int>) {
    val commandArray = command.split(" ")
    when (commandArray[0]) {
        "push_back" -> {
            deque.addLast(commandArray[1].toInt())
        }
        "push_front" -> {
            deque.addFirst(commandArray[1].toInt())
        }
        "pop_front" -> {
            deque.popFront()

        }
        "pop_back" -> {
            deque.popBack()

        }
        "front" -> {
            deque.front()

        }
        "back" -> {
            deque.back()

        }
        "empty" -> {
            deque.empty()

        }
        "size" -> {
            bw.write("${deque.size}\n")

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


fun ArrayDeque<Int>.popFront() {
    if (this.isEmpty()) {
        bw.write("-1\n")
    }else {
        bw.write("${removeFirst()}\n")
    }
}
fun ArrayDeque<Int>.popBack() {
    if (this.isEmpty()) {
        bw.write("-1\n")
    }else {
        bw.write("${removeLast()}\n")
    }
}

fun ArrayDeque<Int>.empty() {
    if (this.isEmpty()) {
        bw.write("1\n")
    } else {
        bw.write("0\n")
    }
}

