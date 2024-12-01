package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day10Test : StringSpec({

    val input1 = readLines("day10test1.txt")
    "Day 10 part 1 test 1" {
        Day10.part1(input1) shouldBe 4
    }

//    "Day 9 part 2" {
//        Day9.part2(input) shouldBe 2
//    }
})
