import com.landsmann.adventofcode.packetScanners
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class Day13Tests : StringSpec({

    "Packet Scanners should result in correct value" {

        val input = """0: 3
1: 2
4: 4
6: 4"""

        packetScanners(input) shouldBe 24
    }
})