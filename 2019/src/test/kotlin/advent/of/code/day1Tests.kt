package advent.of.code

import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class FuelTests : StringSpec({
    "find the fuel required for a module, given its mass" {
        forall(
                row(12, 2),
                row(14, 2),
                row(1969, 654),
                row(100756, 33583)
        ) { mass, result ->
            Day1.findFuel(mass) shouldBe result
        }
    }

    "find fuel requires fuel required for a module, given its mass" {
        forall(
                row(14, 2),
                row(1969, 966),
                row(100756, 50346)
        ) { mass, result ->
            Day1.findFuelPlusFuelForFuel(mass) shouldBe result
        }
    }
})