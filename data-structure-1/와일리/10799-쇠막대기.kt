import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/*
 Stick '('이 나오면 스택에 Stick을 저장
 레이저가 나오면 Stick 을 자르는 레이저 개수를 +1
 레이저가 아닌 ')'가 나오면 스틱을 자르는 레이저 개수를 보고 계산
*/

data class Stick(
    var laserCnt: Int = 0
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val input = br.readLine()
    val deque = ArrayDeque<Stick>()
    var ans = 0
    var idx = 0
    while (idx < input.length) {
        val cur = input[idx]

        // 레이저인 경우
        if (idx < input.length - 1 && cur == '(' && input[idx + 1] == ')') {
            if (deque.isNotEmpty()) {
                deque.last().laserCnt += 1
            }
            idx += 1
        } else if (cur == ')') {
            // ')'인 경우, stick의 끝부분이 나온 경우
            val laserCnt = deque.removeLast().laserCnt
            if (deque.isNotEmpty()) {
                deque.last().laserCnt += laserCnt
            }
            ans += laserCnt + 1
        } else {
            // '('인 경우, stick의 앞부분이 나온 경우
            val stick = Stick()
            deque.addLast(stick)
        }

        idx += 1
    }

    bw.write("$ans")
    bw.flush()
}
