package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object Day6 {

    fun part1(input: List<String>): Long {
        val times = input[0].split(" ").drop(1).filter { it.isNotEmpty() }
        val records = input[1].split(" ").drop(1).filter { it.isNotEmpty() }
        val races = times.zip(records)
            .map { (time, record) -> Race(time.toLong(), record.toLong()) }
        return races.map(::countWinners)
            .reduce { acc, curr -> acc * curr }
    }

    fun part2(input: List<String>): Long {
        val time = input[0].split(" ").drop(1).filter { it.isNotEmpty() }.joinToString("").toLong()
        val record = input[1].split(" ").drop(1).filter { it.isNotEmpty() }.joinToString("").toLong()
        val race = Race(time, record)
        return countWinners(race)
    }

    private fun countWinners(race: Race): Long {
        return (0..race.time)
            .map { millis -> millis * (race.time - millis) }
            .count { it > race.record }.toLong()
    }

    data class Race(val time: Long, val record: Long)

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day6.txt") }
        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}


