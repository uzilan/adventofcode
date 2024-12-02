package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object DayX {
    fun part1(lines: List<String>): Int {
        return 0
    }

    fun part2(lines: List<String>): Int {
        return 0
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("DayX.txt") }
        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}
