package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DayXTest : StringSpec({
    val input = readLines("DayXTest.txt")

    "DayX part 1" {
        DayX.part1(input) shouldBe 1
    }

    "DayX part 2" {
        DayX.part2(input) shouldBe 1
    }
})
