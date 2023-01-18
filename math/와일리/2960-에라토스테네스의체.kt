fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val input = br.readLine().split(" ")
    val n = input[0].toInt()
    val k = input[1].toInt()
    val isPrime = BooleanArray(n + 1) { true }

    var cnt = 0
    for(i in 2..n) {
        if(!isPrime[i]) continue

        var j = i
        while(j <= n) {
            if(isPrime[j]) {
                cnt += 1
                if (cnt == k) {
                    println(j)
                    return
                }
            }
            isPrime[j] = false
            j += i
        }
    }
}
