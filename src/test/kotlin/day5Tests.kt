import com.landsmann.adventofcode.highEntropyPassphrases
import com.landsmann.adventofcode.mazeOfTwistyTrampolines
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class MazeOfTwistyTrampolines : StringSpec({

    "Maze of twisty trampolines should result in correct value" {

        val numbers = """0
3
0
1
-3""".split("\n").map { Integer.parseInt(it) }.toMutableList()


        mazeOfTwistyTrampolines(numbers) shouldBe 5
    }
})