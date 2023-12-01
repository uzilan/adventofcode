package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day2Test : StringSpec({
    val input = readLines("day2test.txt")
    val pairs = Day2.pairs(input)

    "Day 2 part 1" {
        Day2.part1(pairs) shouldBe 15
    }

    "Day 2 part 2" {
        Day2.part2(pairs) shouldBe 12
    }

})
