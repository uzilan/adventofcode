import com.landsmann.adventofcode.highEntropyPassphrases
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day4Tests : StringSpec({

    "High entropy passphrases should result in correct value" {

        val lines =
                """aa bb cc dd ee
aa bb cc dd aa
aa bb cc dd aaa""".split("\n")

        highEntropyPassphrases(lines) shouldBe 2
    }
})