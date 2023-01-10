fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val arr = mutableListOf<Int>()
    val stack = Stack<Int>()
    val sb = StringBuilder()

    repeat(n) {
        val num = br.readLine().toInt()
        arr.add(num)
    }

    var start = 1
    var arrIdx = 0
    while(arrIdx < n && stack.size <= n) {
        if(stack.isNotEmpty() && stack.peek() == arr[arrIdx]) {
            stack.pop()
            sb.append("-\n")
            arrIdx++
        } else {
            stack.add(start)
            sb.append("+\n")
            start++
        }
    }

    if(stack.isEmpty()) {
        bw.write(sb.toString())
    } else {
        bw.write("NO")
    }

    bw.flush()
}
