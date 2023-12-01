import com.landsmann.adventofcode.iHeardYouLikeRegisters
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day8Tests : StringSpec({

    "I Heard You Like Registers should result in correct value" {

        val input = """b inc 5 if a > 1
a inc 1 if b < 5
c dec -10 if a >= 1
c inc -20 if c == 10"""

        iHeardYouLikeRegisters(input) shouldBe 1
    }
})