package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.math.pow
import kotlin.time.ExperimentalTime

object Day4 {

    fun part1(rows: List<Row>): Int =
        rows.map { row -> (row.got intersect row.win.toSet()).size }
            .filter { it != 0 }
            .sumOf { 2.0.pow(it - 1.0) }
            .toInt()

    fun part2(rows: List<Row>): Int {
        val cards = rows
            .map { row -> (row.got intersect row.win.toSet()).size }

        val mults = MutableList(size = cards.size) { 1 }

        cards.forEachIndexed { index, wins ->
            (1..wins).forEach {
                mults[index + it] += mults[index]
            }
        }

        return mults.sum()
    }

    fun parse(lines: List<String>): List<Row> =
        lines.map { line ->
            val (cardIndexString, numbers) = line.split(":")
            val cardIndex = cardIndexString.split(" ").last().toInt()

            val (winString, gotString) = numbers.split("|")
            val win = winString.trim().split(" ")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }
            val got = gotString.trim().split(" ")
                .filter { it.isNotEmpty() }
                .map { it.toInt() }

            Row(cardIndex, win, got)
        }

    data class Row(val index: Int, val win: List<Int>, val got: List<Int>)

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day4.txt") }
        val parse = prep("parsing") { parse(input) }
        printResult("part 1") { part1(parse) }
        printResult("part 2") { part2(parse) }
    }
}

