package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day5Test : StringSpec({
    val input = readLines("day5test.txt")
    val data = Day5.parse(input)

    "Day 5 part 1" {
        Day5.part1(data) shouldBe 35
    }

    "Day 5 part 2" {
        Day5.part2(data) shouldBe 46
    }
})
