import java.io.BufferedReader
import java.io.InputStreamReader

// 원리는 이해가는데 코드로 작성을 못하겠어서 https://blog.naver.com/crm06217/221830562441 참고..
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().toString().split(" ")
    josephus(input[0].toInt(), input[1].toInt())

}
fun josephus(size: Int, number: Int){
    val list = MutableList(size){it+1}

    var count = 0
    val answer = mutableListOf<Int>()
    var queueSize = size
    while (count < queueSize){
        if ((count + 1) % number == 0){
            answer.add(list[count])
        }
        else{
            list.add(list[count])
            queueSize++
        }
        count++
    }
    println(answer.toString().replace("[","<").replace("]",">"))
}