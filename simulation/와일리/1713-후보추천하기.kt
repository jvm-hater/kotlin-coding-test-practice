import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val N = br.readLine().toInt()
    val M = br.readLine().toInt()
    val input = br.readLine().split(" ").map { it.toInt() }

    val rec = IntArray(101)
    val time = IntArray(101)

    val queue = PriorityQueue<Int> { o1, o2 ->
        if (rec[o1] == rec[o2])
            time[o1] - time[o2]
        else
            rec[o1] - rec[o2]
    }

    for (i in 0 until M) {
        val student = input[i]
        rec[student]++

        if (!queue.contains(student)) {
            time[student] = i

            if (queue.size == N)
                rec[queue.poll()] = 0
            queue.offer(student)

        } else {
            queue.remove(student)
            queue.offer(student)
        }
    }


    queue.toList().sorted().forEach { bw.write("$it ") }
    bw.flush()
    bw.close()
}
