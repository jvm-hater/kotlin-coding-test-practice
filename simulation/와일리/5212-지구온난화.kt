fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (l, r) = br.readLine().split(" ").map { it.toInt() }
    val grid = Array(l + 2) { Array(r + 2) { '.' } }
    val newGrid = Array(l + 2) { Array(r + 2) { '.' } }

    for (i in 1..l) {
        val input = br.readLine().toCharArray()
        for (j in 1..r) {
            grid[i][j] = input[j - 1]
        }
    }

    val row = listOf(0, 1, 0, -1)
    val col = listOf(-1, 0, 1, 0)
    for (i in 1..l) {
        for (j in 1..r) {
            if(grid[i][j] == 'X') {
                var cnt = 0

                for(k in 0..3) {
                    if(grid[i + row[k]][j + col[k]] == '.') {
                        cnt += 1
                    }
                }

                if(cnt >= 3) {
                    newGrid[i][j] = '.'
                } else {
                    newGrid[i][j] = 'X'
                }
            } else {
                newGrid[i][j] = '.'
            }
        }
    }

    var rowMin = Int.MAX_VALUE
    var rowMax = Int.MIN_VALUE
    var colMin = Int.MAX_VALUE
    var colMax = Int.MIN_VALUE
    for (i in 1..l) {
        for (j in 1..r) {
           if(newGrid[i][j] == 'X') {
               rowMin = min(i, rowMin)
               rowMax = max(i, rowMax)
               colMin = min(j, colMin)
               colMax = max(j, colMax)
           }
        }
    }

    for (i in rowMin..rowMax) {
        for (j in colMin..colMax) {
            bw.write("${newGrid[i][j]}")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}
