package com.landsmann.adventofcode

import java.lang.Long.toBinaryString

private val factorA: Long = 16807
private val factorB: Long = 48271
private val devidee: Long = 2147483647

fun duelingGenerators(origA: Long, origB: Long): Int {
    var a = origA
    var b = origB

    return (0..40000000).count {
        a = a * factorA % devidee
        b = b * factorB % devidee

        val last16a = toBinaryString(a).takeLast(16)
        val last16b = toBinaryString(b).takeLast(16)

        last16a == last16b
    }
}

fun main(args: Array<String>) {
    println(duelingGenerators(618, 814))
}