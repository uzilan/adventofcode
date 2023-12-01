package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

typealias TwoRanges = List<List<Set<Int>>>

object Day4 {
    fun part1(pairs: TwoRanges): Int {
        return pairs
            .count {
                it.first().containsAll(it.last())
                    || it.last().containsAll(it.first())
            }
    }

    fun part2(pairs: TwoRanges): Int {
        return pairs
            .count { it.first().intersect(it.last()).isNotEmpty() }
    }

    fun pairs(input: List<String>): TwoRanges = input.map { line ->
        line.split(",")
            .map { pair -> pair.split("-") }
            .map { (it.first().toInt()..it.last().toInt()).toSet() }
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day4.txt") }
        val pairs = prep("parsing") { pairs(input) }
        printResult("part 1") { part1(pairs) }
        printResult("part 2") { part2(pairs) }
    }
}
