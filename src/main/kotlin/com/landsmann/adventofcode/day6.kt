package com.landsmann.adventofcode

// http://adventofcode.com/2017/day/6

private val memoryLane = mutableListOf<String>()

fun memoryReallocation(numbers: MutableList<Int>): Int {
    var steps = 0

    while (true) {
        val joinedNumbers = numbers.joinToString("#")
        if (memoryLane.contains(joinedNumbers)) {
            return steps
        }
        memoryLane.add(joinedNumbers)

        val max = numbers.max()
        val index = numbers.indexOf(max)

        numbers[index] = 0
        distributeNumbers(max!!, index, numbers)
        steps++
    }
}

private fun distributeNumbers(count: Int, index: Int, numbers: MutableList<Int>) {
    if (count == 0) {
        return
    }
    val nextIndex = when (index) {
        numbers.count() - 1 -> 0
        else -> index + 1
    }

    numbers[nextIndex]++
    distributeNumbers(count - 1, nextIndex, numbers)
}

fun main(args: Array<String>) {
    val numbers = "10 3 15 10 5 15 5 15 9 2 5 8 5 2 3 6".split(" ").map { Integer.parseInt(it) }.toMutableList()
    println(memoryReallocation(numbers))
}