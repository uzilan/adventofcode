package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day1Test : StringSpec({
    val input1 = readLines("day1test.txt")
    val input2 = readLines("day1test2.txt")

    "Day 1 part 1" {
        Day1.part1(input1) shouldBe 142
    }

    "Day 1 part 2" {
        Day1.part2(input2) shouldBe 281
    }
})
