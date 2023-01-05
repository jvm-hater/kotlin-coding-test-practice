import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val inputCount = br.readLine().toInt()
    for (i in 0 until inputCount) {
        val bracket = br.readLine()
        validateBracket(bracket)
    }

}
fun validateBracket(bracket: String){
    val bracketStack = mutableListOf<Char>()
    for (i in bracket.indices){
        if (bracket[i] == ')' && bracketStack.lastOrNull() == '('){
            bracketStack.removeLast()
        }
        else {
            bracketStack.add(bracket[i])
        }
    }
    if (bracketStack.isEmpty()){
        println("YES")
    }
    else{
        println("NO")
    }

}