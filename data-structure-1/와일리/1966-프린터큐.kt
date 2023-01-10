data class Document(
    val order: Int,
    val priority: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    repeat(n) {
        val firstInput = br.readLine().split(" ")
        val targetPos = firstInput[1].toInt()

        val secondInput = br.readLine().split(" ")
        val deque = ArrayDeque<Document>()
        for(i in secondInput.indices) {
            val doc = Document(i, secondInput[i].toInt())
            deque.addLast(doc)
        }

        val sortedArr = secondInput.sortedDescending()
        var arrIdx = 0
        var printOrder = 1
        while(deque.isNotEmpty()) {
            val doc = deque.removeFirst()
            
            if(doc.priority == sortedArr[arrIdx].toInt()) {
                if(doc.order == targetPos) {
                    bw.write("$printOrder\n")
                    break
                }
                printOrder++
                arrIdx++
            } else {
                deque.addLast(doc)
            }
        }
    }

    bw.flush()
}
