package adventofcode

import java.io.File
import java.lang.ClassLoader.getSystemResource
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

object Utils {

    fun readText(fileName: String): String {
        return File(getSystemResource(fileName).file).readText()
    }

    fun readLines(fileName: String, trim: Boolean = true): List<String> {
        val readLines = File(getSystemResource(fileName).file)
            .readLines()
        return if (trim) readLines.map(String::trim)
        else readLines
    }

    fun readLinesAsInts(fileName: String): List<Int> {
        return readLines(fileName).map { it.toInt() }
    }

    fun readAndSplitLineItems(fileName: String, delimiter: String = " "): List<List<String>> {
        return readLines(fileName)
            .map { line -> line.split(delimiter) }

    }

    fun readAndSplitLineItemsAsInts(fileName: String, delimiter: String = " "): List<List<Int>> {
        return readAndSplitLineItems(fileName, delimiter)
            .map { line -> line.map { it.toInt() } }
    }

    @ExperimentalTime
    fun <T> prep(message: String, block: () -> T): T {
        val (result, duration) = measureTimedValue {
            block()
        }
        println("$message ($duration)")
        return result
    }

    @ExperimentalTime
    fun <T> printResult(message: String, block: () -> T) {
        val (result, duration) = measureTimedValue {
            block()
        }
        println("$message: $result ($duration)")
    }

    fun gcd(x: Long, y: Long): Long = if (y == 0L) x else gcd(y, x % y)

    fun lcm(numbers: List<Long>): Long = numbers.fold(1) { x, y -> x * (y / gcd(x, y)) }

    fun <T> List<T>.dropAt(i: Int): List<T> = subList(0, i) + subList(i + 1, size)
}
