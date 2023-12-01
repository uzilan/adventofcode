import com.landsmann.adventofcode.duelingGenerators
import com.landsmann.adventofcode.permutationPromenade
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day16Tests : StringSpec({

    "Permutation Promenade should result in correct value" {
        val programs = ('a'..'e')
        val input = "s1,x3/4,pe/b"
        permutationPromenade(programs, input) shouldBe "baedc"
    }
})