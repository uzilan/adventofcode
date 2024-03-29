package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day6Test : StringSpec({
    val input = readLines("day6test.txt")

    "Day 6 part 1" {
        Day6.part1(input) shouldBe 288
    }

    "Day 6 part 2" {
        Day6.part2(input) shouldBe 71503
    }
})
