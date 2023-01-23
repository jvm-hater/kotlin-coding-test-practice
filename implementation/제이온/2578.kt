import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val board = mutableListOf<List<Block>>()
    for (i in 1..5) {
        val numbers = reader.readLine().split(" ").map { Block(it.toInt(), false) }
        board.add(numbers)
    }

    val inputs = mutableListOf<Int>()
    for (i in 1..5) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        inputs.addAll(numbers)
    }

    var count = 1
    for (input in inputs) {
        val block = findBlock(input, board)
        block.marked = true

        if (isBingo(board)) {
            break
        }
        count++
    }

    writer.write("$count\n")
    writer.flush()
    writer.close()
    reader.close()
}

fun findBlock(number: Int, board: List<List<Block>>): Block {
    for (i in board) {
        for (j in i) {
            if (j.number == number) {
                return j
            }
        }
    }
    throw RuntimeException()
}

fun isBingo(board: List<List<Block>>): Boolean {
    var colBingoCount = 0
    for (i in board) {
        if (i.all { it.marked }) {
            colBingoCount++
        }
    }

    var rowBingoCount = 0
    for (i in 0..4) {
        val temp = listOf(board[0][i], board[1][i], board[2][i], board[3][i], board[4][i])
        if (temp.all { it.marked }) {
            rowBingoCount++
        }
    }

    var diagonalBingoCount = 0

    val temp1 = listOf(board[0][0], board[1][1], board[2][2], board[3][3], board[4][4])
    if (temp1.all { it.marked }) {
        diagonalBingoCount++
    }
    val temp2 = listOf(board[0][4], board[1][3], board[2][2], board[3][1], board[4][0])
    if (temp2.all { it.marked }) {
        diagonalBingoCount++
    }

    return (colBingoCount + rowBingoCount + diagonalBingoCount) >= 3
}

class Block(var number: Int, var marked: Boolean)
