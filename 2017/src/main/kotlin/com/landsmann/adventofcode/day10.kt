package com.landsmann.adventofcode

fun knotHash(input: List<Int>, list: List<Int> = (0..255).toList()): Int {
    var currentPosition = 0
    var skipSize = 0
    var currentList = list

    input.forEach {
        currentList = reverseCirularRange(currentList, currentPosition, it)
        currentPosition = it + skipSize
        skipSize++
    }

    currentList = moveListXSteps(currentList, skipSize)

    return currentList[0] * currentList[1]
}

private fun reverseCirularRange(list: List<Int>, fromIndex: Int, numberOfElements: Int): List<Int> {
    val movedList = moveListXSteps(list, fromIndex)
    val sublistToReverse = movedList.take(numberOfElements)
    val reversedSublist = sublistToReverse.reversed()
    val restOfList = movedList.takeLast(movedList.count() - numberOfElements)
    val unionedList = reversedSublist.union(restOfList).toList()
    val restoredList = moveListXStepsReverse(unionedList, fromIndex)

    return restoredList
}

private fun moveListXSteps(list: List<Int>, steps: Int): List<Int> {
    val endWith = list.take(steps)
    val beginWith = list.takeLast(list.count() - steps)
    val unioned = beginWith.union(endWith)
    return unioned.toList()
}

private fun moveListXStepsReverse(list: List<Int>, steps: Int): List<Int> {
    return moveListXSteps(list, list.count() - steps)
}


fun main(args: Array<String>) {
    //val shortRange = (0..4).toList()
    //val input = listOf(3, 4, 1, 5)
    val input = listOf(147, 37, 249, 1, 31, 2, 226, 0, 161, 71, 254, 243, 183, 255, 30, 70)
    println(knotHash(input))
}