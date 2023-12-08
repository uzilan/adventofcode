package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day7Test : StringSpec({
    val input = readLines("day7test.txt")
    val parse1 = Day7.parse1(input)
    val parse2 = Day7.parse2(input)

    "Day 7 part 1" {
        Day7.part1(parse1) shouldBe 6440
    }

    "Day 7 part 2" {
        Day7.part2(parse2) shouldBe 5905
    }
})
