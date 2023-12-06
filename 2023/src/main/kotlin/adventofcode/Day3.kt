package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object Day3 {
    private val numberRegex = """(\d+)""".toRegex()
    private val symbolRegex = """([^.\d])""".toRegex()

    fun part1(lines: List<String>): Int {
        val numbers = lines.map { findUsingRegex(numberRegex, it) }
        val symbols = lines.map { findUsingRegex(symbolRegex, it) }

        val mapIndexed = numbers.mapIndexed { rowIndex, nums ->
            nums.filter { num ->
                val above = if (rowIndex > 0) symbolsCloseByOnRow(symbols[rowIndex - 1], num) else false
                val same = symbolsCloseByOnSameRow(symbols[rowIndex], num)
                val below = if (rowIndex < symbols.size - 1) symbolsCloseByOnRow(symbols[rowIndex + 1], num) else false
                above || same || below
            }
        }
        val flatten = mapIndexed
            .flatten()

        println(flatten.map { it.value }.joinToString("\n"))
        return flatten
            .sumOf {
                it.value.toInt()
            }
    }

    private fun symbolsCloseByOnSameRow(symbols: List<Thing>, number: Thing): Boolean {
        return symbols.any { sym ->
            val before = sym.index == number.index - 1
            val after = sym.index == number.index + number.value.length
            before || after
        }
    }

    private fun symbolsCloseByOnRow(symbols: List<Thing>, number: Thing): Boolean {
        return symbols.any { sym ->
            val before = sym.index >= number.index - 1
            val after = sym.index <= number.index + number.value.length
            before && after
        }
    }

    private data class Thing(val index: Int, val value: String)

    private fun findUsingRegex(regex: Regex, line: String): List<Thing> {
        val toList = regex.findAll(line)
            .map { it.groupValues[0] }.toList()

        return toList.fold(listOf()) { acc, curr ->
            val index = if (acc.isEmpty()) 0 else acc.last().index
            val value = line.indexOf(curr, index + 1)
            acc + Thing(value, curr)
        }
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day3Marcus.txt") }
        printResult("part 1") { part1(input) }
//        printResult("part 2") { part2(games) }
    }
}

//527369
