import com.landsmann.adventofcode.duelingGenerators
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day15Tests : StringSpec({

    "Dueling Generators should result in correct value" {
        duelingGenerators(65, 8921) shouldBe 588
    }
})