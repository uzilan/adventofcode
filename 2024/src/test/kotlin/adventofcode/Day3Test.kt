package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day3Test : StringSpec({
    val input1 = readLines("Day3Test1.txt")
    val input2 = readLines("Day3Test2.txt")

    "Day3 part 1" {
        Day3.part1(input1) shouldBe 161
    }

    "Day3 part 2" {
        Day3.part2(input2) shouldBe 48
    }
})
