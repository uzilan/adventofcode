package advent.of.code

import java.io.File
import kotlin.system.measureTimeMillis

object Day1 {
    fun findFuel(mass: Int): Int = mass / 3 - 2

    tailrec fun findFuelPlusFuelForFuel(mass: Int, result: Int = 0): Int {
        val fuel = findFuel(mass)
        return if (fuel <= 0) result
        else findFuelPlusFuelForFuel(fuel, result + fuel)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val lines = File("src/main/resources/day1Input.txt").readLines()

        val time1 = measureTimeMillis {
            val sum1 = lines.sumBy { findFuel(it.toInt()) }
            println("part1: $sum1")
        }
        println("($time1 milliseconds)")

        val time2 = measureTimeMillis {
            val sum2 = lines.sumBy { findFuelPlusFuelForFuel(it.toInt()) }
            println("part2: $sum2")
        }
        println("($time2 milliseconds)")
    }
}