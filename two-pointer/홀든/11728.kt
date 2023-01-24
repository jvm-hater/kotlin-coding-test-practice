import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val list1 = br.readLine().split(" ").map { it.toInt() }
    val list2 = br.readLine().split(" ").map { it.toInt() }
    val answerList = mutableListOf<Int>()
    var pointer1 = 0
    var pointer2 = 0
    while (pointer1 != list1.size || pointer2 != list2.size) {
        if (pointer2 == list2.size) {
            answerList.add(list1[pointer1])
            pointer1++
        } else if (pointer1 == list1.size) {
            answerList.add(list2[pointer2])
            pointer2++
        } else {
            if (list1[pointer1] < list2[pointer2]) {
                answerList.add(list1[pointer1])
                pointer1++
            } else {
                answerList.add(list2[pointer2])
                pointer2++
            }

        }
    }
    answerList.forEach {
        bw.write("$it ")
    }
    bw.flush()
    bw.close()
}
// 첫 답: 풀리긴 하지만 시간 초과
//fun main() {
//    val br = BufferedReader(InputStreamReader(System.`in`))
//    val input = br.readLine().split(" ")
//    var count = 0
//    input.forEach {
//        count += it.toInt()
//    }
//    val list1 = mutableListOf<Int>()
//    val list2 = mutableListOf<Int>()
//    list1.addAll(br.readLine().split(" ").map { it.toInt() })
//    list2.addAll(br.readLine().split(" ").map { it.toInt() })
//
//    val answerList = mutableListOf<Int>()
//
//    while (list1.isNotEmpty() || list2.isNotEmpty()) {
//        if (list2.isEmpty()) {
//            answerList.add(list1.removeFirst())
//        } else if (list1.isEmpty()) {
//            answerList.add(list2.removeFirst())
//        } else {
//            if (list1[0] <= list2[0]) {
//                answerList.add(list1.removeFirst())
//            } else {
//                answerList.add(list2.removeFirst())
//            }
//
//        }
//    }
//    bw.write(answerList.toString().replace("[", "").replace("]", "").replace(",", ""))
//    bw.flush()
//}