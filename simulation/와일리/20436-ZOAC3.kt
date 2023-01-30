fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var (l, r) = br.readLine().split(" ")
    val input = br.readLine().toCharArray().map { it.toString() }
    val left = generateLeftKeyboard()
    val right = generateRightKeyboard()

    var ans = 0
    for(i in input.indices) {
        val str = input[i]
        if(left.containsKey(str)) {
            val prev = left[l]
            val cur = left[str]
            l = str
            ans += abs(prev!![0] - cur!![0]) + abs(prev[1] - cur[1])
        }

        if(right.containsKey(str)) {
            val prev = right[r]
            val cur = right[str]
            r = str
            ans += abs(prev!![0] - cur!![0]) + abs(prev[1] - cur[1])
        }

        ans += 1
    }

    bw.write("$ans")
    bw.flush()
    bw.close()
}

fun generateLeftKeyboard(): Map<String, List<Int>> {
    val keyboard = mutableMapOf<String, List<Int>>()
    keyboard["q"] = listOf(0, 0)
    keyboard["w"] = listOf(0, 1)
    keyboard["e"] = listOf(0, 2)
    keyboard["r"] = listOf(0, 3)
    keyboard["t"] = listOf(0, 4)
    keyboard["a"] = listOf(1, 0)
    keyboard["s"] = listOf(1, 1)
    keyboard["d"] = listOf(1, 2)
    keyboard["f"] = listOf(1, 3)
    keyboard["g"] = listOf(1, 4)
    keyboard["z"] = listOf(2, 0)
    keyboard["x"] = listOf(2, 1)
    keyboard["c"] = listOf(2, 2)
    keyboard["v"] = listOf(2, 3)
    return keyboard
}

fun generateRightKeyboard(): Map<String, List<Int>> {
    val keyboard = mutableMapOf<String, List<Int>>()
    keyboard["y"] = listOf(0, 5)
    keyboard["u"] = listOf(0, 6)
    keyboard["i"] = listOf(0, 7)
    keyboard["o"] = listOf(0, 8)
    keyboard["p"] = listOf(0, 9)
    keyboard["h"] = listOf(1, 5)
    keyboard["j"] = listOf(1, 6)
    keyboard["k"] = listOf(1, 7)
    keyboard["l"] = listOf(1, 8)
    keyboard["b"] = listOf(2, 4)
    keyboard["n"] = listOf(2, 5)
    keyboard["m"] = listOf(2, 6)
    return keyboard
}
