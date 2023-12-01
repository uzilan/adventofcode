package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object Day3 {
    fun part1(input: List<String>): Int {
        return input
            .map { it.chunked(it.length / 2) }
            .map {
                it.first().toSet()
                    .intersect(it.last().toSet())
                    .first()
                    .code
            }
            .map { value(it) }
            .sumOf { it }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3)
            .map {
                it.first().toSet()
                    .intersect(it[1].toSet())
                    .intersect(it.last().toSet())
                    .first()
                    .code
            }
            .map { value(it) }
            .sumOf { it }
    }

    private const val a = 'a'.code
    private const val aa = 'A'.code

    private fun value(it: Int): Int {
        return if (it < a) it - aa + 27 else it - a + 1
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day3.txt") }
        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}
