package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day5Test : StringSpec({
    val input = readLines("day5test.txt", false)

    "Day 5 part 1" {
        Day5.part1(Day5.parse(input, 4, 3)) shouldBe "CMZ"
    }

    "Day 5 part 2" {
        Day5.part2(Day5.parse(input, 4, 3).copy()) shouldBe "MCD"
    }
})
