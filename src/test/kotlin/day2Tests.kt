import com.landsmann.adventofcode.checksum
import com.landsmann.adventofcode.parseMatrix
import com.landsmann.adventofcode.sumOfSimilar
import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

class ChecksumTests : StringSpec({

    "Checksum should result in correct value" {

        val matrix = parseMatrix("""
5   1   9   5
7   5   3
2   4   6   8
""")

        checksum(matrix) shouldBe 18
    }
})