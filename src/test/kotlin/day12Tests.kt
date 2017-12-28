import com.landsmann.adventofcode.digitalPlumber
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day12Tests : StringSpec({

    "Digital Plumber should result in correct value" {

        val input = """0 <-> 2
1 <-> 1
2 <-> 0, 3, 4
3 <-> 2, 4
4 <-> 2, 3, 6
5 <-> 6
6 <-> 4, 5"""

        digitalPlumber(input) shouldBe 6
    }
})