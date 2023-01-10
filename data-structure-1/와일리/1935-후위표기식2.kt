fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val exp = br.readLine()
    val nums = mutableListOf<Int>()
    val stack = Stack<Double>()

    repeat(n) {
        nums.add(br.readLine().toInt())
    }

    for(i in exp.indices) {
        val c = exp[i]
        if(c in 'A'..'Z') {
            val num = nums[c.toInt() - 65]
            stack.push(num.toDouble())
        } else {
            val b = stack.pop()
            val a = stack.pop()
            val c = when(c) {
                '+' -> a + b
                '-' -> a - b
                '*' -> a * b
                else -> a / b
            }

            stack.push(c)
        }
    }

    bw.write("%.2f".format(stack.pop()))

    bw.flush()
}
