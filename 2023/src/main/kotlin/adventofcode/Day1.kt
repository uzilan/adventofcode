package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object Day1 {
    fun part1(lines: List<String>): Int =
        lines.sumOf { line ->
            val digits = line.filter { it.isDigit() }
            "${digits.first()}${digits.last()}".toInt()
        }

    fun part2(lines: List<String>): Int =
        lines.sumOf { line ->
            parse(line)
        }

    private val nums = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    private fun parse(line: String): Int = "${findFirst(line)}${findLast(line)}".toInt()

    private fun findFirst(line: String): Int {
        if (line.first().isDigit()) return line.first().digitToInt()
        val found = nums.find { line.startsWith(it) }
        return if (found != null) nums.indexOf(found) + 1
        else findFirst(line.drop(1))
    }

    private fun findLast(line: String): Int {
        if (line.last().isDigit()) return line.last().digitToInt()
        val found = nums.find { line.endsWith(it) }
        return if (found != null) nums.indexOf(found) + 1
        else findLast(line.dropLast(1))
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day1.txt") }
        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}
