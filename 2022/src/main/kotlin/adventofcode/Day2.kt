package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

typealias Pairs = List<Pair<String, String>>

object Day2 {
    fun part1(pairs: Pairs): Int {
        return pairs
            .map { score(it) + shapeScore(it.second) }
            .sumOf { it }
    }

    fun part2(pairs: Pairs): Int {
        return pairs
            .map { score2(it) + shapeScore2(it) }
            .sumOf { it }
    }

    fun pairs(input: List<String>): Pairs = input.map {
        val split = it.split(" ")
        split[0] to split[1]
    }

    // A, X -> rock
    // B, Y -> paper
    // C, Z -> scissors
    private fun score(pair: Pair<String, String>): Int {
        return when (pair) {
            "A" to "X", "B" to "Y", "C" to "Z" -> 3 // draw
            "A" to "Y", "B" to "Z", "C" to "X" -> 6 // I win
            "A" to "Z", "B" to "X", "C" to "Y" -> 0 // I lose
            else -> 0
        }
    }

    // score based on shape
    private fun shapeScore(shape: String) = when (shape) {
        "X" -> 1
        "Y" -> 2
        "Z" -> 3
        else -> 0
    }

    // score based on lose/draw/win
    private fun score2(it: Pair<String, String>) = when (it.second) {
        "X" -> 0
        "Y" -> 3
        "Z" -> 6
        else -> 0
    }

    //    X -> lose
    //    Y -> draw
    //    Z -> win
    private fun shapeScore2(pair: Pair<String, String>) = when (pair) {
        "A" to "X" -> 3
        "A" to "Y" -> 1
        "A" to "Z" -> 2
        "B" to "X" -> 1
        "B" to "Y" -> 2
        "B" to "Z" -> 3
        "C" to "X" -> 2
        "C" to "Y" -> 3
        "C" to "Z" -> 1
        else -> 0
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day2.txt") }
        val pairs = prep("parsing") { pairs(input) }
        printResult("part 1") { part1(pairs) }
        printResult("part 2") { part2(pairs) }
    }
}
