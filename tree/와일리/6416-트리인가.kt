fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    var num = 0
    loopA@while (true) {
        val graph = mutableMapOf<Int, Int>()
        num++

        loopB@ while (true) {
            val inputs = br.readLine().split("  ")

            for (input in inputs) {
                if (input.isEmpty()) {
                    continue
                }

                val a = input.split(" ")[0].toInt()
                val b = input.split(" ")[1].toInt()

                if (a == -1 && b == -1) {
                    break@loopA
                }

                if (a == 0 && b == 0) {
                    break@loopB
                }

                graph[a] = graph.getOrDefault(a, 0)
                graph[b] = graph.getOrDefault(b, 0) + 1
            }
        }

        val graphList = graph.toList()
        
        if(graphList.isEmpty()) {
            bw.write("Case $num is a tree.\n")
            continue@loopA
        }
        
        // 조건 1 확인
        val rootCnt = graphList.count { it.second == 0 }
        if(rootCnt != 1) {
            bw.write("Case $num is not a tree.\n")
            continue@loopA
        }

        // 조건 2 확인
        if(!graphList.all { it.second == 0 || it.second == 1 }) {
            bw.write("Case $num is not a tree.\n")
            continue@loopA
        }

        // 조건3 확인
        if(graph.size - 1 != graph.values.sum()) {
            bw.write("Case $num is not a tree.\n")
            continue@loopA
        }

        // 트리
        bw.write("Case $num is a tree.\n")
    }
    bw.flush()
}
