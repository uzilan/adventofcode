package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object Day1 {
    fun part1(lines: List<String>): Int = 1

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("Day1.txt") }
        printResult("part 1") { part1(input) }
    }
}
