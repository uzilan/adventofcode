package adventofcode

import adventofcode.Utils.readText
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day1Test : StringSpec({
    val input = readText("day1test.txt")
    val lines = Day1.lines(input)

    "Day 1 part 1" {
        Day1.part1(lines) shouldBe 24000
    }

    "Day 1 part 2" {
        Day1.part2(lines) shouldBe 45000
    }
})
