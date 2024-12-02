package adventofcode

import adventofcode.Utils.dropAt
import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readAndSplitLineItemsAsInts
import kotlin.math.abs
import kotlin.time.ExperimentalTime

typealias Report = List<Int>
typealias Reports = List<Report>

object Day2 {
    fun part1(reports: Reports): Int = reports.filter(::isSafe).size

    fun part2(reports: Reports): Int = reports.filter { report ->
        isSafe(report) || reportsWithOneLevelRemoved(report).any { isSafe(it) }
    }.size

    private fun reportsWithOneLevelRemoved(report: Report): Reports = report.indices.map { report.dropAt(it) }

    private fun isSafe(report: Report): Boolean = (isIncreasing(report) || isDecreasing(report)) && isSafeDiff(report)

    private fun isIncreasing(report: Report) = report.sorted().distinct() == report

    private fun isDecreasing(report: Report) = report.sorted().distinct().reversed() == report

    private fun isSafeDiff(report: Report) = report.zipWithNext()
        .all { abs(it.second - it.first) in 1..3 }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readAndSplitLineItemsAsInts("Day2.txt") }
        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}
