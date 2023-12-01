package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day3Test : StringSpec({
    val input = readLines("day3test.txt")

    "Day 3 part 1" {
        Day3.part1(input) shouldBe 157
    }

    "Day 3 part 2" {
        Day3.part2(input) shouldBe 70
    }

})
