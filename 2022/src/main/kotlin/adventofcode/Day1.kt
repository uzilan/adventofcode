package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readText
import kotlin.time.ExperimentalTime

object Day1 {
    fun part1(lines: List<Int>): Int {
        return lines.maxOf { it }
    }

    fun part2(lines: List<Int>): Int {
        return lines
            .sorted()
            .takeLast(3)
            .sumOf { it }
    }

    fun lines(input: String): List<Int> = input.split("\n\n")
        .map { lines ->
            lines.split("\n")
                .sumOf { it.toInt() }
        }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readText("day1.txt") }
        val lines = prep("parsing") { lines(input) }
        printResult("part 1") { part1(lines) }
        printResult("part 2") { part2(lines) }
    }
}
