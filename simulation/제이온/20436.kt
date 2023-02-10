import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.`out`))

    val inputs = reader.readLine().split(" ")
    val (left, right) = inputs.map { it.toCharArray()[0] }
    val arr = reader.readLine()

    val keyboard = init()
    var result = 0

    var beforeLeftButton = keyboard.find { it.name == left }!!
    var beforeRightButton = keyboard.find { it.name == right }!!
    for (char in arr) {
        val button = keyboard.find { it.name == char }!!

        if (button == beforeLeftButton || button == beforeRightButton) {
            result++
            continue
        }

        if (button.isConsonant) {
            val distance = calculateDistance(button.x, beforeLeftButton.x, button.y, beforeLeftButton.y)
            beforeLeftButton = button
            result += distance + 1
        } else {
            val distance = calculateDistance(button.x, beforeRightButton.x, button.y, beforeRightButton.y)
            beforeRightButton = button
            result += distance + 1
        }
    }

    writer.write("$result\n")
    writer.flush()
    writer.close()
    reader.close()
}

private fun init(): List<Button> {
    return listOf(
        Button(0, 0, 'q', true),
        Button(0, 1, 'w', true),
        Button(0, 2, 'e', true),
        Button(0, 3, 'r', true),
        Button(0, 4, 't', true),
        Button(0, 5, 'y', false),
        Button(0, 6, 'u', false),
        Button(0, 7, 'i', false),
        Button(0, 8, 'o', false),
        Button(0, 9, 'p', false),
        Button(1, 0, 'a', true),
        Button(1, 1, 's', true),
        Button(1, 2, 'd', true),
        Button(1, 3, 'f', true),
        Button(1, 4, 'g', true),
        Button(1, 5, 'h', false),
        Button(1, 6, 'j', false),
        Button(1, 7, 'k', false),
        Button(1, 8, 'l', false),
        Button(2, 0, 'z', true),
        Button(2, 1, 'x', true),
        Button(2, 2, 'c', true),
        Button(2, 3, 'v', true),
        Button(2, 4, 'b', false),
        Button(2, 5, 'n', false),
        Button(2, 6, 'm', false),
    )
}

private fun calculateDistance(x1: Int, x2: Int, y1: Int, y2: Int): Int {
    return abs(x1 - x2) + abs(y1 - y2)
}

data class Button(val x: Int, val y: Int, val name: Char, val isConsonant: Boolean)
