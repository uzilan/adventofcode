package com.landsmann.adventofcode

private data class Scanner(val depth: Int, val range: Int, var current: Int = 0) {
    var movingDown = true
    fun move() {
        if (movingDown && current == range - 1) {
            movingDown = false
            current--
        } else if (!movingDown && current == 0) {
            movingDown = true
            current++
        } else if (movingDown) {
            current++
        } else {
            current--
        }
    }
}

fun packetScanners(input: String): Int {
    val rows = input.split("\n")
    val scanners = rows.map {
        val split = it.split(":")
        Scanner(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()))
    }

    val noOfLayers = scanners.maxBy { it.depth }?.depth
    var severity = 0
    (0..noOfLayers!!).forEachIndexed { i, _ ->
        val currentScanner = scanners.find { it.depth == i }
        if (currentScanner?.current == 0) {
            severity += currentScanner.range * currentScanner.depth
        }
        scanners.forEach { it.move() }
    }
    return severity
}

fun main(args: Array<String>) {
    val input = """0: 3
1: 2
2: 4
4: 4
6: 5
8: 8
10: 6
12: 6
14: 8
16: 6
18: 6
20: 8
22: 12
24: 8
26: 8
28: 12
30: 8
32: 12
34: 9
36: 14
38: 12
40: 12
42: 12
44: 14
46: 14
48: 10
50: 14
52: 12
54: 14
56: 12
58: 17
60: 10
64: 14
66: 14
68: 12
70: 12
72: 18
74: 14
78: 14
82: 14
84: 24
86: 14
94: 14"""

    println(packetScanners(input))
}