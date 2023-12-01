package advent.of.code

import advent.of.code.Day2.Processing.Done
import advent.of.code.Day2.Processing.Ongoing
import java.io.File

object Day2 {

    fun restoreGravity(data: MutableList<Int>): Int {
        var i = 0
        var status = Ongoing
        while (status == Ongoing) {
            status = nextInstruction(data, i)
            i += 4
        }
        return data[0]
    }

    private fun nextInstruction(list: MutableList<Int>, pos: Int): Processing {
        val opcode = list[pos]
        if (opcode == 99) return Done

        val parameter1 = list[pos + 1]
        val parameter2 = list[pos + 2]
        val changeAddress = list[pos + 3]

        list[changeAddress] = if (opcode == 1) list[parameter1] + list[parameter2]
        else list[parameter1] * list[parameter2]

        return Ongoing
    }

    enum class Processing { Done, Ongoing }

    @JvmStatic
    fun main(args: Array<String>) {
        val line = File("src/main/resources/day2Input.txt").readText()
        val input = line.split(",").map { it.toInt() }.toMutableList()
        input[1] = 12
        input[2] = 2
        println("part 1: ${restoreGravity(input)}")

        // the equation can be formed like:
        // 19690720 = 406198 + 207360 * noun + verb
        val wantedResult = 19690720
        val startBuffer = 406198 // noun = 0 and verb = 0
        val withoutBuffer = wantedResult - startBuffer
        val nounWorth = 207360 // every noun is worth 207360. Every verb is worth 1
        val noun = withoutBuffer / nounWorth
        val verb = withoutBuffer - nounWorth * noun
        println("part 2: ${100 * noun + verb}")
    }
}
