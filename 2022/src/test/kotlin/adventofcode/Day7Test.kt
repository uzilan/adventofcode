package adventofcode

import adventofcode.Utils.readLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day7Test : StringSpec({
    val input = readLines("day7test.txt")
    val dirs = Day7.dirs(input)

    "Day 7 part 1" {
        Day7.part1(dirs) shouldBe 95437
    }

    "Day 7 part 2" {
        Day7.part2(dirs) shouldBe 24933642
    }

})
