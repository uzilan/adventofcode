package com.landsmann.adventofcode

// http://adventofcode.com/2017/day/6

fun memoryReallocation(numbers: MutableList<Int>): Int {
    val visitedNumbers = mutableListOf<Int>()
    var steps = 1

    while (true) {
        val max = numbers.max()
        val index = numbers.indexOf(max)
        if (visitedNumbers.contains(index)) {
            return steps
        }
        numbers[index] = 0
        distributeNumbers(max!!, index, numbers)
        steps++
        visitedNumbers.add(index)
    }
}

fun distributeNumbers(count: Int, index: Int, numbers: MutableList<Int>) {
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