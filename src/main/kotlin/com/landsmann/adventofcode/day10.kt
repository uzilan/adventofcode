package com.landsmann.adventofcode

fun knotHash(input: List<Int>, list: List<Int> = (0..255).toList()): Int {


    return 0
}

// reverseCirularRange((0, 1, 2, 3, 4), x, y) -> move list x steps -> reverse y numbers -> move list -x steps
// reverseCirularRange((0, 1, 2, 3, 4), 1, 0) -> (2, 3, 4, 0, 1) -> (2, 3, 4, 0, 1) ->  (0, 1, 2, 3, 4)
// reverseCirularRange((0, 1, 2, 3, 4), 1, 1) -> (2, 3, 4, 0, 1) -> (3, 2, 4, 0, 1) ->  (0, 1, 3, 2, 4)
// reverseCirularRange((0, 1, 2, 3, 4), 1, 2) -> () -> () -> ()
// reverseCirularRange((0, 1, 2, 3, 4), 1, 3) -> (2, 3, 4, 0, 1) -> (0, 4, 3, 2, 1) -> (2, 1, 0, 4, 3)
private fun reverseCirularRange(list: List<Int>, fromIndex: Int, numberOfElements: Int): List<Int> {
    return emptyList()
}

// moveListXSteps((0, 1, 2, 3, 4), 2) -> (2, 3, 4, 0, 1)
private fun moveListXSteps(range: List<Int>, steps: Int): List<Int> {
    val endWith = range.take(steps)
    val beginWith = range.toList().subList(steps, range.count())
    val unioned = beginWith.union(endWith)
    return unioned.toList()
}

// moveListXStepsRevers((0, 1, 2, 3, 4), 2) -> (3, 4, 0, 1, 2)
private fun moveListXStepsRevers(range: List<Int>, steps: Int): List<Int> {
    val beginWith = range.toList().subList(range.count() - steps, range.count())
    val endWith = range.take(range.count() - steps)
    val unioned = beginWith.union(endWith)
    return unioned.toList()
}


fun main(args: Array<String>) {
    val shortRange = (0..4).toList()
    val input = listOf(3, 4, 1, 5)
    println(knotHash(input, shortRange))
}