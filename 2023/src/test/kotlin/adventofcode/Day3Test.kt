package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day3Test : StringSpec({
    val input = readLines("day3test.txt")
//    val input2 = readLines("day1test2.txt")

    "Day 3 part 1" {
        Day3.part1(input) shouldBe 4361
    }

//    "Day 1 part 2" {
//        Day1.part2(input2) shouldBe 281
//    }
})
