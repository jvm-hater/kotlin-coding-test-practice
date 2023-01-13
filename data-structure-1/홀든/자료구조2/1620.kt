import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val bw = BufferedWriter(OutputStreamWriter(System.`out`))

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ")
    val pokedex = hashMapOf<Int, String>()
    val pokedex2 = hashMapOf<String, Int>()
    for (i in 0 until input[0].toInt()){
        val pokemon = br.readLine()
        pokedex[i+1] = pokemon
        pokedex2[pokemon] = i+1

    }
    for (i in 0 until input[1].toInt()){
        val search = br.readLine()
        try {
            bw.write(pokedex[search.toInt()]+"\n")
        }
        catch (e: Exception){
            bw.write(pokedex2[search].toString() +"\n")
        }
    }
    bw.flush()
}