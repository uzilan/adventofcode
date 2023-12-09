package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readAndSplitLineItemsAsInts
import kotlin.time.ExperimentalTime

object Day9 {

    fun part1(input: List<List<Int>>): Int = input.sumOf { line ->
        line.last() + helper1(line)
    }

    fun part2(input: List<List<Int>>): Int = input.sumOf { line ->
        line.first() - helper2(line)
    }

    private fun helper1(input: List<Int>): Int {
        val diffs = input.zipWithNext().map { it.second - it.first }
        return if (diffs.all { it == 0 }) 0
        else diffs.last() + helper1(diffs)
    }

    private fun helper2(input: List<Int>): Int {
        val diffs = input.zipWithNext().map { it.second - it.first }
        return if (diffs.all { it == 0 }) 0
        else diffs.first() - helper2(diffs)
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readAndSplitLineItemsAsInts("day9.txt") }
        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}


