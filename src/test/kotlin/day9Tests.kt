import com.landsmann.adventofcode.streamProcessing
import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

class Day9Tests : StringSpec({

    "Stream Processing should result in correct value" {
        val table = table(
                headers("input", "value"),
                row("{}", 1),
                row("{{{}}}", 6),
                row("{{},{}}", 5),
                row("{{{},{},{{}}}}", 16),
                row("{<a>,<a>,<a>,<a>}", 1),
                row("{{<ab>},{<ab>},{<ab>},{<ab>}}", 9),
                row("{{<!!>},{<!!>},{<!!>},{<!!>}}", 9),
                row("{{<a!>},{<a!>},{<a!>},{<ab>}}", 3)
        )

        forAll(table) { input, expectedResult ->
            streamProcessing(input) shouldBe expectedResult
        }
    }
})