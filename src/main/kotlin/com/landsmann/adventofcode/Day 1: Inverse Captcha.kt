package com.landsmann.adventofcode

// http://adventofcode.com/2017/day/1

fun sumOfSimilar(number: Int): Int {
    val sequence = number.toString().toCharArray()
    return (0 until sequence.size).sumBy { digitIfCurrentMatchingNextDigit(sequence, it) }
}

private fun digitIfCurrentMatchingNextDigit(sequence: CharArray, index: Int): Int =
        when {
            index < sequence.size - 1 -> digitIfSame(sequence[index], sequence[index + 1])
            else -> digitIfSame(sequence.last(), sequence.first())
        }


private fun digitIfSame(first: Char, second: Char): Int =
        if (first == second) Integer.parseInt("" + first) else 0




