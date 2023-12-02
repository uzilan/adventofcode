package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day2Test : StringSpec({
    val input = readLines("day2test.txt")
    val games = input.map(Day2::parseGame)

    "Day 2 part 1" {
        Day2.part1(games) shouldBe 8
    }

    "Day 2 part 2" {
        Day2.part2(games) shouldBe 2286
    }
})
