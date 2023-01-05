import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val inputCount = br.readLine().toInt()
    val stack = mutableListOf<Int>()
    for (i in 0 until inputCount) {
        val command = br.readLine()
        chooseQueueCommand(command, stack)
    }

}

fun chooseQueueCommand(command: String, stack: MutableList<Int>) {

    if (command.contains("push")) {
        stack.push(command.split(" ").last().toInt())
    }
    if (command.contains("pop")) {
        stack.pop()
    }
    if (command.contains("front")) {
        stack.front()
    }
    if (command.contains("back")) {
        stack.back()
    }
    if (command.contains("empty")) {
        stack.empty()
    }
    if (command.contains("size")) {
        println(stack.size)
    }

}

fun MutableList<Int>.push(value: Int) {
    add(value)
}

fun MutableList<Int>.front() {
    if (this.isEmpty()) {
        println(-1)
    } else {
        println(this.first())
    }
}
fun MutableList<Int>.back() {
    if (this.isEmpty()) {
        println(-1)
    } else {
        println(this.last())
    }
}


fun MutableList<Int>.pop() {
    if (this.isEmpty()) {
        println(-1)
        return
    }
    val topValue = this.first()
    removeFirst()
    println(topValue)
}

fun MutableList<Int>.empty() {
    if (this.isEmpty()) {
        println(1)
    } else {
        println(0)
    }
}
