fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    if(n % 2 == 0){
        bw.write("CY");
    } else {
        bw.write("SK");
    }
    
    bw.flush()
    bw.close()
}
