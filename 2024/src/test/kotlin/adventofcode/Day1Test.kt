package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day1Test : StringSpec({
    val input1 = readLines("Day1Test.txt")

    "Day 1 part 1" {
        Day1.part1(input1) shouldBe 1
    }
})
