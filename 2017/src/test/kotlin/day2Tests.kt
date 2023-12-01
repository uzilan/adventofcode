import com.landsmann.adventofcode.corruptionChecksum
import com.landsmann.adventofcode.parseMatrix
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day2Tests : StringSpec({

    "Corruption checksum should result in correct value" {

        val matrix = parseMatrix("""
5   1   9   5
7   5   3
2   4   6   8
""")

        corruptionChecksum(matrix) shouldBe 18
    }
})