package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readAndSplitLineItemsAsInts
import kotlin.math.abs
import kotlin.time.ExperimentalTime

object Day2 {
    fun part1(reports: List<List<Int>>): Int = reports.filter(::safe).size

    fun part2(reports: List<List<Int>>): Int = reports.filter { report ->
        safe(report) || drops(report).any { safe(it) }
    }.size

    private fun drops(report: List<Int>): List<List<Int>> =
        report.indices.map { report.subList(0, it) + report.subList(it + 1, report.size) }

    private fun safe(report: List<Int>): Boolean = (increasing(report) || decreasing(report)) && safeDiff(report)

    private fun increasing(report: List<Int>) = report.sorted().distinct() == report

    private fun decreasing(report: List<Int>) = report.sorted().distinct().reversed() == report

    private fun safeDiff(report: List<Int>) = report.zipWithNext()
        .all { abs(it.second - it.first) in 1..3 }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readAndSplitLineItemsAsInts("Day2.txt") }
        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}
