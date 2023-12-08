package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object Day8 {

    fun part1(directions: String, map: HashMap<String, LR>): Int {

        var steps = 0
        var index = 0
        var curr = "AAA"

        while (curr != "ZZZ") {
            val line = map[curr]
            if (index == directions.length) index = 0
            val nextDirection = directions[index]
            curr = if (nextDirection == 'L') line!!.left else line!!.right
            steps++
            index++
        }

        return steps
    }

    fun part2(directions: String, map: HashMap<String, LR>): Int {

        var steps = 0
        var index = 0
        var currs = map.keys.filter { it.endsWith('A') }

        while (!currs.all { it.endsWith('Z') }) {
            val lines = currs.map { map[it] }
            if (index == directions.length) index = 0
            val nextDirection = directions[index]
            currs = lines.map { line -> if (nextDirection == 'L') line!!.left else line!!.right }
            steps++
            index++
        }

        return steps
    }

    data class LR(val left: String, val right: String)

    fun parse(input: List<String>): Pair<String, HashMap<String, LR>> {
        val directions = input.first()
        val map = input.drop(2).associate { line ->
            val from = line.take(3)
            val left = line.substring(7, 10)
            val right = line.substring(12, 15)
            from to LR(left, right)
        }

        return directions to HashMap(map)
    }


    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day8.txt") }
        val (directions, map) = prep("parsing") { parse(input) }
        printResult("part 1") { part1(directions, map) }
        printResult("part 2") { part2(directions, map) }
    }
}


