val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.`out`))
val ans = StringBuilder()

fun main() {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val visit = Array(n + 1) { false }

    permutation(0, n, m, visit)
    bw.flush()
    bw.close()
}

fun permutation(cnt: Int, n: Int, m: Int, visit: Array<Boolean>) {
    if(cnt == m) {
        bw.write(ans.toString() + "\n")
        return
    }

    for(i in 1..n) {
        if(!visit[i]){
            ans.append(i).append(" ")
            visit[i] = true
            permutation(cnt+1, n, m, visit)
            ans.delete(ans.length - 2, ans.length)
            visit[i] = false
        }
    }
}
