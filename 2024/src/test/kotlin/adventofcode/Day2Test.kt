package adventofcode

import adventofcode.Utils.readAndSplitLineItemsAsInts
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day2Test : StringSpec({
    val input1 = readAndSplitLineItemsAsInts("Day2Test.txt")

    "Day 2 part 1" {
        Day2.part1(input1) shouldBe 2
    }

    "Day 2 part 2" {
        Day2.part2(input1) shouldBe 4
    }
})
