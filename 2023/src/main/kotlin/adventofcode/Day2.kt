package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object Day2 {
    fun part1(games: List<Game>): Int =
        games.filter { !it.impossible() }
            .sumOf { it.index }

    fun part2(games: List<Game>): Int =
        games.sumOf { it.power() }

    enum class Color { blue, red, green }
    data class Cube(val number: Int, val color: Color) {
        fun impossible(): Boolean {
            return when (color) {
                Color.red -> number > 12
                Color.green -> number > 13
                Color.blue -> number > 14
            }
        }
    }

    data class CubeGroup(val cubes: List<Cube>) {
        fun impossible(): Boolean = cubes.any { it.impossible() }
    }

    data class Game(val index: Int, val cubeGroups: List<CubeGroup>) {
        fun impossible(): Boolean = cubeGroups.any { it.impossible() }
        fun power(): Int = cubeGroups.flatMap { it.cubes }
            .groupBy { it.color }
            .mapValues { (_, cubes) -> cubes.maxBy { it.number } }
            .values
            .map { it.number }
            .reduce(Int::times)
    }

    fun parseGame(line: String): Game {
        val (indexPart, groupsPart) = line.split(":")
        val index = indexPart.drop("Game ".length).toInt()
        val groups = groupsPart.split(";")
            .map(::parseGroup)
        return Game(index, groups)
    }

    private fun parseGroup(group: String): CubeGroup = CubeGroup(
        group.split(",")
            .map(::parseCube)
    )

    private fun parseCube(cube: String): Cube {
        val (num, color) = cube.trim().split(" ")
        return Cube(num.toInt(), Color.valueOf(color))
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day2.txt") }
        val games = prep("parsing") { input.map(::parseGame) }
        printResult("part 1") { part1(games) }
        printResult("part 2") { part2(games) }
    }
}

