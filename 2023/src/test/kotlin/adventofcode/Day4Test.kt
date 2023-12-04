package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day4Test : StringSpec({
    val input = readLines("day4test.txt")
    val rows = Day4.parse(input)

    "Day 4 part 1" {
        Day4.part1(rows) shouldBe 13
    }

    "Day 4 part 2" {
        Day4.part2(rows) shouldBe 30
    }
})
