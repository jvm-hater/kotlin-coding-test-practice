import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var input = br.readLine().toInt()
    // 조건 : 가장 큰 5를 계속 빼다가, 5를 뺀 값이 2와 5로도 나눠지지 않는다면 2로 뺀다.

    var count = 0
    while (input != 0) {
        if (input == -1){
            count = -1
            break
        }
        if (((input - 5) / 5 == 0 && (input-5) %2 != 0) || input < 5) {
            input -= 2
            count++
        }
        else{
            input -= 5
            count++
        }
    }
    bw.write(count.toString())
    bw.flush()
}