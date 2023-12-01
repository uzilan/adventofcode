import com.landsmann.adventofcode.spiralMemory
import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

class Day3Tests : StringSpec({

    "Distance to spiral middle should result in correct value" {
        val table = table(
                headers("place in spiral", "expected result"),
                //row(1, 0),
                row(12, 3),
                row(23, 2),
                row(1024, 32)
        )

        forAll(table) { placeInSpiral, expectedResult ->
            spiralMemory(placeInSpiral) shouldBe expectedResult
        }
    }
})