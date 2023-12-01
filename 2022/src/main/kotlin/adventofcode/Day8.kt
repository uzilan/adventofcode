package adventofcode

import kotlin.time.ExperimentalTime

object Day8 {
    fun part1(input: List<String>): Int {
        return input.mapIndexed { rowIndex, row ->
            row.filterIndexed { colIndex, col ->
                val digit = col.digitToInt()
                when {
                    isOnTheEdge(input, colIndex, rowIndex) -> true
                    row.take(colIndex).allShorterThan(digit) -> true
                    row.takeLast(row.length - colIndex - 1).allShorterThan(digit) -> true
                    input.take(rowIndex).map { it[colIndex] }.joinToString("").allShorterThan(digit) -> true
                    input.takeLast(input.size - rowIndex - 1).map { it[colIndex] }.joinToString("")
                        .allShorterThan(digit) -> true

                    else -> false
                }
            }
        }.sumOf { it.length }
    }

    fun part2(input: List<String>): Int {
        val mapIndexed = input.mapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, col ->
                if (isOnTheEdge(input, colIndex, rowIndex)) 0
                else {
                    val digit = col.digitToInt()
                    row.take(colIndex).reversed().countUntilBlocking(digit) *
                        row.takeLast(row.length - colIndex - 1).countUntilBlocking(digit) *
                        input.take(rowIndex).map { it[colIndex] }.joinToString("").reversed()
                            .countUntilBlocking(digit) *
                        input.takeLast(input.size - rowIndex - 1).map { it[colIndex] }.joinToString("")
                            .countUntilBlocking(digit)
                }
            }
        }

        return 0
    }

    private fun String.countUntilBlocking(c: Int): Int {
        return takeWhile { it.digitToInt() < c }.length
    }

    private fun String.allShorterThan(c: Int): Boolean {
        return map { it.digitToInt() }
            .all { it < c }
    }

    private fun isOnTheEdge(
        input: List<String>,
        colIndex: Int,
        rowIndex: Int,
    ) = colIndex == 0 ||
        colIndex == input[0].length - 1 ||
        rowIndex == 0 ||
        rowIndex == input.size - 1

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.prep("reading") { Utils.readLines("day8.txt") }

        Utils.printResult("part 1") { part1(input) } // 1513699
    }
}