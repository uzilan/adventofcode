package adventofcode

import kotlin.time.ExperimentalTime

object Day6 {
    fun part1(input: String) = findUniques(input, 4)
    fun part2(input: String) = findUniques(input, 14)

    private fun findUniques(input: String, size: Int): Int {
        val seq = input.windowed(size)
            .first { it.toSet().size == size }
        return input.indexOf(seq) + size
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.prep("reading") { Utils.readText("day6.txt") }

        Utils.printResult("part 1") { part1(input) }
        Utils.printResult("part 2") { part2(input) }
    }
}