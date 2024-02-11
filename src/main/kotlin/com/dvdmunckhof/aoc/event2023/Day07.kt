package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.groupCount

class Day07(private val input: List<String>) {

    fun solvePart1(): Int = solve(false)

    fun solvePart2(): Int = solve(true)

    private fun solve(supportsJokers: Boolean): Int {
        val hands = input.map {
            val cards = it.substring(0, 5)
            val bid = it.substring(6).toInt()
            Hand(cards, bid, supportsJokers)
        }
        return hands.sortedBy { it.score }
            .mapIndexed { i, hand -> (i + 1) * hand.bid }
            .sum()
    }

    private data class Hand(val cards: String, val bid: Int, private val supportsJokers: Boolean) {
        val score = calculateScore()

        private fun calculateScore(): Int {
            return cards.fold(rank()) { score, card ->
                val cardValue = when (card) {
                    'A' -> 14
                    'K' -> 13
                    'Q' -> 12
                    'J' -> if (supportsJokers) 1 else 11
                    'T' -> 10
                    else -> card.digitToInt()
                }
                score shl 4 or cardValue
            }
        }

        private fun rank(): Int {
            val map = cards.groupCount()
            val jokers = if (supportsJokers) map.remove('J') ?: 0 else 0
            val max = map.values.maxOrNull() ?: 0
            return when (max + jokers) {
                5 -> 7 // five of a kind
                4 -> 6 // four of a kind
                3 -> if (map.size == 2) 5 else 4 // full house or 3 of a kind
                2 -> if (map.size == 3) 3 else 2 // 2 pair or 1 pair
                else -> 1 // high card
            }
        }
    }
}
