import com.landsmann.adventofcode.iHeardYouLikeRegisters
import com.landsmann.adventofcode.knotHash
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day10Tests : StringSpec({

    "Knot Hash should result in correct value" {
        val shortRange = (0..4).toList()
        val input = listOf(3, 4, 1, 5)
        knotHash(input, shortRange) shouldBe 12
    }
})