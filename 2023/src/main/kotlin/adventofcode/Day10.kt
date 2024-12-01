package adventofcode

import kotlin.time.ExperimentalTime

object Day10 {

    fun part1(input: List<String>): Int {
        val lineWithS = input.indexOfFirst { line -> line.contains("S") }
        val indexOfS = input[lineWithS].indexOf('S')
        val sCoords = Coords(lineWithS, indexOfS)
        val map = mutableMapOf(sCoords to 0)

        fun helper(coords: Coords, previous: Coords, first: Boolean = true) {
            if (!first) {
                val previousScore = map[previous]!!
                val score = map[coords]
                if (score == null || score > previousScore + 1) {
                    map[coords] = previousScore + 1
                }
            }

            val neighbours = findNeighbours(coords, input) - previous
            if (neighbours.isEmpty() || (input.at(coords) == 'S' && !first)) return

            neighbours.forEach { neighbour ->
                helper(neighbour, coords, false)
            }
        }

        helper(sCoords, sCoords)

        return 0
    }


    private fun findNeighbours(coords: Coords, input: List<String>): List<Coords> {
        val northCoords = Coords(coords.line - 1, coords.col)
        val eastCoords = Coords(coords.line, coords.col + 1)
        val southCoords = Coords(coords.line + 1, coords.col)
        val westCoords = Coords(coords.line, coords.col - 1)

        val north = when {
            northCoords.line == -1 -> null
            input.at(northCoords) in listOf('F', '|', '7') -> northCoords
            else -> null
        }

        val east = when {
            eastCoords.col == input[0].length -> null
            input.at(eastCoords) in listOf('J', '-', '7') -> eastCoords
            else -> null
        }

        val south = when {
            southCoords.line == input.size -> null
            input.at(southCoords) in listOf('L', '|', 'J') -> southCoords
            else -> null
        }

        val west = when {
            westCoords.col == -1 -> null
            input.at(westCoords) in listOf('L', '-', 'F') -> westCoords
            else -> null
        }

        return listOfNotNull(north, east, south, west)
    }

    data class Coords(val line: Int, val col: Int)

    fun List<String>.at(coords: Coords): Char = this[coords.line][coords.col]

//    fun part2(input: List<List<Int>>): Int = input.sumOf { line ->
//        line.first() - helper2(line)
//    }


    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
//        val input = prep("reading") { readAndSplitLineItemsAsInts("day9.txt") }
//        printResult("part 1") { part1(input) }
//        printResult("part 2") { part2(input) }
    }
}


