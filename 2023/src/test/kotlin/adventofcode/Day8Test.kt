package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day8Test : StringSpec({

    "Day 8 part 1 test 1" {
        val input = readLines("day8test1.txt")
        val (directions, map) = Day8.parse(input)
        Day8.part1(directions, map) shouldBe 2
    }

    "Day 8 part 1 test 2" {
        val input = readLines("day8test2.txt")
        val (directions, map) = Day8.parse(input)
        Day8.part1(directions, map) shouldBe 6
    }

    "Day 8 part 2" {
        val input = readLines("day8test3.txt")
        val (directions, map) = Day8.parse(input)
        Day8.part2(directions, map) shouldBe 6
    }
})
