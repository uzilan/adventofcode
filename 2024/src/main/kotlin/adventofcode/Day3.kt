package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object Day3 {
    fun part1(input: List<String>): Int {
        val reggie = """mul\(\d\d?\d?,\d\d?\d?\)""".toRegex()
        val result = reggie.findAll(input.joinToString(""))
        val muls = result.toList().map { it.groupValues.first() }
        return sumIt(muls)
    }

    fun part2(input: List<String>): Int {
        val reggie = """do\(\)|don't\(\)|mul\(\d\d?\d?,\d\d?\d?\)""".toRegex()
        val result = reggie.findAll(input.joinToString(""))
        val muls = result.toList().map { it.groupValues.first() }

        var ok = true
        val enabledMuls = muls.fold(emptyList<String>()) { acc, curr ->
            if (curr.startsWith("mul") && ok) acc + curr
            else if (curr == "don't()") acc.also { ok = false }
            else if (curr == "do()") acc.also { ok = true }
            else acc
        }
        return sumIt(enabledMuls)
    }

    private fun sumIt(muls: List<String>): Int {
        return muls.map { mul ->
            mul.drop(4).dropLast(1)
                .split(",")
                .map { it.toInt() }
        }.sumOf { it.first() * it.last() }
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("Day3.txt") }
        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}
