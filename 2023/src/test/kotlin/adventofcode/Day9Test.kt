package adventofcode

import adventofcode.Utils.readAndSplitLineItemsAsInts
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day9Test : StringSpec({

    val input = readAndSplitLineItemsAsInts("day9test.txt")
    "Day 9 part 1" {
        Day9.part1(input) shouldBe 114
    }

    "Day 9 part 2" {
        Day9.part2(input) shouldBe 2
    }
})
