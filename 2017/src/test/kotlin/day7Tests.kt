import com.landsmann.adventofcode.recursiveCircus
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day7Tests : StringSpec({

    "Recursive circus should result in correct value" {

        val input = """pbga (66)
xhth (57)
ebii (61)
havc (66)
ktlj (57)
fwft (72) -> ktlj, cntj, xhth
qoyq (66)
padx (45) -> pbga, havc, qoyq
tknk (41) -> ugml, padx, fwft
jptl (61)
ugml (68) -> gyxo, ebii, jptl
gyxo (61)
cntj (57)"""

        recursiveCircus(input) shouldBe "tknk"
    }
})