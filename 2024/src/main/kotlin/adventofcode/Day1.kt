package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readAndSplitLineItemsAsInts
import kotlin.math.abs
import kotlin.time.ExperimentalTime

object Day1 {
    fun part1(lines: List<List<Int>>): Int {
        val left = lines.map { it.first() }.sorted()
        val right = lines.map { it.last() }.sorted()
        return left.zip(right).sumOf { abs(it.second - it.first) }
    }

    fun part2(lines: List<List<Int>>): Int {
        val left = lines.map { it.first() }
        val right = lines.map { it.last() }

        return left.fold(0) { acc, curr ->
            val count = right.count { it == curr }
            acc + curr * count
        }
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readAndSplitLineItemsAsInts("Day1.txt", "   ") }
        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}
