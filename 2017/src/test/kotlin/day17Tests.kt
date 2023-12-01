import com.landsmann.adventofcode.spinlock
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day17Tests : StringSpec({

    "Spinlock should result in correct value" {
        spinlock(3) shouldBe 638
    }
})