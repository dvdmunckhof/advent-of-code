package com.dvdmunckhof.aoc.event2023

class Day04(private val input: List<String>) {

    fun solvePart1(): Int {
        return matchingCardNumbers().filter { it > 0 }.sumOf { 1 shl it - 1 }
    }

    fun solvePart2(): Int {
        val cardsCount = Array(input.size) { 1 }

        for ((index, matches) in matchingCardNumbers().withIndex()) {
            val cardCount = cardsCount[index]
            for (i in index+1..index+matches) {
                cardsCount[i] += cardCount
            }
        }

        return cardsCount.sum()
    }

    private fun matchingCardNumbers(): Sequence<Int> {
        val firstLine = input[0]
        val colonIndex = firstLine.indexOf(':')
        val pipeIndex = firstLine.indexOf('|', colonIndex)
        val winningRange = (colonIndex + 2)..<pipeIndex step 3
        val numbersRange = (pipeIndex + 2)..firstLine.lastIndex step 3

        return input.asSequence().map { line ->
            val winningNumbers = winningRange.map { i -> line.substring(i, i + 2) }.toHashSet()
            numbersRange.count { i -> line.substring(i, i + 2) in winningNumbers }
        }
    }
}
