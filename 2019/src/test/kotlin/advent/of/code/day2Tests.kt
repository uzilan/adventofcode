package advent.of.code

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class IntcodeTests : StringSpec({
    "restore the gravity assist program" {
        forall(
                row(listOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50), 3500),
                row(listOf(1, 0, 0, 0, 99), 2),
                row(listOf(2, 3, 0, 3, 99), 2),
                row(listOf(2, 4, 4, 5, 99, 0), 2),
                row(listOf(1, 1, 1, 4, 99, 5, 6, 0, 99), 30)
        ) { input, result ->
            Day2.restoreGravity(input.toMutableList()) shouldBe result
        }
    }
})