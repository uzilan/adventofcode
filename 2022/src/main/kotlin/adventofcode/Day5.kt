package adventofcode

import adventofcode.Day5.Move
import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

typealias Stack = ArrayDeque<Char>
typealias StacksAndMoves = Pair<List<Stack>, List<Move>>

object Day5 {
    fun part1(data: StacksAndMoves): String {
        val (stacks, moves) = data

        moves.forEach { move ->
            repeat(move.count) {
                val ch = stacks[move.from].removeLast()
                stacks[move.to].add(ch)
            }
        }

        return stacks.map { it.last() }.joinToString("")
    }

    fun part2(data: StacksAndMoves): String {
        val (stacks, moves) = data

        moves.forEach { move ->
            val toMove = stacks[move.from].takeLast(move.count)
            repeat(move.count) { stacks[move.from].removeLast() }
            stacks[move.to].addAll(toMove)
        }

        return stacks.map { it.last() }.joinToString("")
    }

    fun parse(input: List<String>, rowCount: Int, stackCount: Int): StacksAndMoves {
        val stacks = (0 until stackCount).map { Stack() }
        input.take(rowCount - 1)
            .map { it.chunked(4) }
            .reversed()
            .forEach { line ->
                line.forEachIndexed { i, c ->
                    val crate = c.trim()
                    if (crate.isNotEmpty()) {
                        stacks[i].add(c[1])
                    }
                }
            }

        val regex = """move (\d+) from (\d+) to (\d+)""".toRegex()
        val moves = input.drop(rowCount + 1)
            .map { line -> regex.find(line)!!.groupValues.drop(1).map { it.toInt() } }
            .map { Move(it.first(), it[1] - 1, it.last() - 1) }

        return Pair(stacks, moves)
    }

    data class Move(val count: Int, val from: Int, val to: Int)

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day5.txt", false) }

        printResult("part 1") { part1(prep("parsing") { parse(input, 9, 9) }) }
        printResult("part 2") { part2(prep("parsing") { parse(input, 9, 9) }) }
    }
}