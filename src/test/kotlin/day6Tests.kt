import com.landsmann.adventofcode.mazeOfTwistyTrampolines
import com.landsmann.adventofcode.memoryReallocation
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day6Tests : StringSpec({

    "Memory reallocation should result in correct value" {

        val numbers = "0 2 7 0".split(" ").map { Integer.parseInt(it) }.toMutableList()

        memoryReallocation(numbers) shouldBe 5
    }
})