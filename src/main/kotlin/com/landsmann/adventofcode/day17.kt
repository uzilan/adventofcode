package com.landsmann.adventofcode

private val times = 2017

fun spinlock(steps: Int): Int {
    val buffer = mutableListOf(0)
    var currentPosition = 0

    (0 until times).forEachIndexed { index, _ ->
        currentPosition = spin(buffer, currentPosition, steps) + 1
        buffer.add(currentPosition, index + 1)
    }

    return buffer[currentPosition + 1]
}

private fun spin(buffer: MutableList<Int>, fromPosition: Int, steps: Int): Int {
    return (fromPosition + steps) % buffer.size
}

fun main(args: Array<String>) {
    println(spinlock(303))
}