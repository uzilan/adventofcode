package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day8Test : StringSpec({
    val input = readLines("day8test.txt")

    "Day 8 part 1" {
        Day8.part1(input) shouldBe 21
    }

    "Day 8 part 2" {
        Day8.part2(input) shouldBe 8
    }

})
