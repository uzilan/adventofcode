package adventofcode

import adventofcode.Day7.Type.FiveOfAKind
import adventofcode.Day7.Type.FourOfAKind
import adventofcode.Day7.Type.FullHouse
import adventofcode.Day7.Type.HighCard
import adventofcode.Day7.Type.OnePair
import adventofcode.Day7.Type.ThreeOfAKind
import adventofcode.Day7.Type.TwoPair
import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object Day7 {

    fun part1(hands: List<Hand>): Long {
        return sortAndCalculate(hands)
    }

    fun part2(hands: List<Hand>): Long {
        return sortAndCalculate(hands)
    }

    private fun sortAndCalculate(hands: List<Hand>): Long {
        val sorted = hands.sortedWith(compareBy<Hand> { it.type }
            .thenByDescending { it.values.first() }
            .thenByDescending { it.values[1] }
            .thenByDescending { it.values[2] }
            .thenByDescending { it.values[3] }
            .thenByDescending { it.values.last() }
        ).reversed()

        return sorted.mapIndexed { index, hand -> hand.bid * (index + 1) }.sum().toLong()
    }

    enum class Type { FiveOfAKind, FourOfAKind, FullHouse, ThreeOfAKind, TwoPair, OnePair, HighCard }
    data class Hand(val values: List<Int>, val type: Type, val bid: Int)

    fun parse1(input: List<String>): List<Hand> = input.map { line ->
        val (cards, bid) = line.split(" ")
        val values = parseValues1(cards)
        val type = parseType1(values)
        Hand(values, type, bid.toInt())
    }

    fun parse2(input: List<String>): List<Hand> = input.map { line ->
        val (cards, bid) = line.split(" ")
        val values = parseValues2(cards)
        val type = parseType2(values)
        Hand(values, type, bid.toInt())
    }

    private fun parseType1(values: List<Int>): Type {
        val groups = values.groupingBy { it }.eachCount()
        val maxSize = groups.values.max()
        return when (groups.size) {
            1 -> FiveOfAKind
            2 -> if (maxSize == 4) FourOfAKind else FullHouse
            3 -> if (maxSize == 3) ThreeOfAKind else TwoPair
            4 -> OnePair
            else -> HighCard
        }
    }

    private fun parseType2(values: List<Int>): Type {
        val groups = values.groupBy { it }
            .toList()
            .sortedBy { (_, values) -> values.size }
            .reversed()
            .toMap()

        val maxSize = groups.values.maxOfOrNull { it.size }
        val keys = groups.keys.toList()
        return when {
            groups.size == 1 -> FiveOfAKind // XXXXX
            groups.size == 2 && maxSize == 4 && keys.last() == 1 -> FiveOfAKind // XXXXJ
            groups.size == 2 && maxSize == 4 -> FourOfAKind // XXXXY
            groups.size == 2 && keys.last() == 1 -> FiveOfAKind // XXXJJ
            groups.size == 2 -> FullHouse // XXXYY
            groups.size == 3 && maxSize == 3 && keys.drop(1).contains(1) -> FourOfAKind // XXXJY or XXXYJ
            groups.size == 3 && maxSize == 3 -> ThreeOfAKind // XXXYZ
            groups.size == 3 && keys.dropLast(1).contains(1) -> FourOfAKind // JJXXY or XXJJY
            groups.size == 3 && keys.last() == 1 -> FullHouse // XXYYJ
            groups.size == 3 -> TwoPair // XXYYZ
            groups.size == 4 && keys.contains(1) -> ThreeOfAKind // JJXYZ or XXYZJ or XXYJZ or XXJYZ
            groups.size == 4 -> OnePair // XXYZP
            keys.contains(1) -> OnePair // JXYZP or XJYZP or XYJZP or XYZJP or XYZPJ
            else -> HighCard
        }
    }

    private fun parseValues1(cards: String): List<Int> = cards.map { card ->
        when (card) {
            'A' -> 14
            'K' -> 13
            'Q' -> 12
            'J' -> 11
            'T' -> 10
            else -> card.digitToInt()
        }
    }

    private fun parseValues2(cards: String): List<Int> = cards.map { card ->
        when (card) {
            'A' -> 14
            'K' -> 13
            'Q' -> 12
            'J' -> 1
            'T' -> 10
            else -> card.digitToInt()
        }
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day7.txt") }
        val parse1 = prep("parsing 1") { parse1(input) }
        val parse2 = prep("parsing 2") { parse2(input) }
//        printResult("part 1") { part1(parse1) }
        printResult("part 2") { part2(parse2) }
    }
}


