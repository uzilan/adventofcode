package adventofcode

import adventofcode.Utils.readAndSplitLineItemsAsInts
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day1Test : StringSpec({
    val input1 = readAndSplitLineItemsAsInts("Day1Test.txt", "   ")

    "Day 1 part 1" {
        Day1.part1(input1) shouldBe 11
    }

    "Day 1 part 2" {
        Day1.part2(input1) shouldBe 31
    }
})
