import com.landsmann.adventofcode.sumOfSimilar
import io.kotlintest.matchers.shouldBe
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

class CaptchaTests : StringSpec({

    "Captcha should result in correct value" {
        val table = table(
                headers("captcha", "expected result"),
                row(1122, 3),
                row(1111, 4),
                row(1234, 0),
                row(91212129, 9)
        )

        forAll(table) { captcha, expectedResult ->
            sumOfSimilar(captcha.toBigInteger()) shouldBe expectedResult
        }
    }
})