package advent.of.code

import java.io.File
import kotlin.math.abs

object Day3 {

    fun closestIntersectionPoint(wire1: String, wire2: String): Int {
        val (_, _, intersect) = createLists(wire1, wire2)
        return intersect.map { Coords(abs(it.x), abs(it.y)) }
                .minBy { it.x + it.y }
                .let { it!!.x + it.y }
    }

    fun fewestCombinedSteps(wire1: String, wire2: String): Int {
        val (data1, data2, intersect) = createLists(wire1, wire2)
        return intersect.map {
            data1.indexOf(it) + data2.indexOf(it)
        }.min()!!
    }

    private fun createLists(wire1: String, wire2: String): Triple<MutableList<Coords>, MutableList<Coords>, List<Coords>> {
        val data1 = saveCoordinates(wire1)
        val data2 = saveCoordinates(wire2)
        val intersect = data1.intersect(data2)
                .filterNot { it.x == 0 && it.y == 0 }

        return Triple(data1, data2, intersect)
    }

    private fun saveCoordinates(wire1: String): MutableList<Coords> {
        val data = mutableSetOf(Coords())
        wire1.split(",")
                .forEach { instruction ->
                    data.addAll(nextCoords(instruction, data.last()))
                }
        return data.toMutableList()
    }

    private fun nextCoords(instruction: String, last: Coords): List<Coords> {
        val range = 0..instruction.size()
        return when (instruction.direction()) {
            'R' -> range.map { x -> Coords(last.x + x, last.y) }
            'U' -> range.map { y -> Coords(last.x, last.y + y) }
            'L' -> range.map { x -> Coords(last.x - x, last.y) }
            else -> range.map { y -> Coords(last.x, last.y - y) }
        }
    }

    private fun String.direction(): Char = this.first()
    private fun String.size(): Int = this.substring(1).toInt()
    data class Coords(val x: Int = 0, val y: Int = 0)

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = File("src/main/resources/day3Input.txt").readLines()
        val part1 = closestIntersectionPoint(lines[0], lines[1])
        println("part 1: $part1")

        val part2 = fewestCombinedSteps(lines[0], lines[1])
        println("part 2: $part2")
    }
}