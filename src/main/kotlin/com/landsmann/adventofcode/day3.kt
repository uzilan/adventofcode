package com.landsmann.adventofcode

import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.math.truncate

// http://adventofcode.com/2017/day/3

// solution found here: https://karlfish.github.io/haskell/advent-of-code/2017/12/08/deriving-direct-formula-aoc.html

fun spiralMemory(number: Int): Int {
    val layer = findLayer(number)
    val distance = findDistance(number, layer)
    return distance
}

// L+|(n−1 mod 2L)−L|
fun findDistance(number: Int, layer: Int): Int =
        layer + abs(((number - 1) % (layer * 2) - layer))

// L=⌈1/2(√(n−1))⌉
fun findLayer(number: Int): Int =
        truncate(0.5 * sqrt((number.toDouble() - 1))).toInt()

fun main(args: Array<String>) {
    println(spiralMemory(12))
}