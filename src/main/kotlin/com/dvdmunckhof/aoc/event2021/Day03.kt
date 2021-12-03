package com.dvdmunckhof.aoc.event2021

class Day03(private val input: List<String>) {
    private val bitIndices = 0 until input.first().length

    fun solvePart1(): Int {
        var gamma = 0
        var epsilon = 0

        for (index in bitIndices) {
            val count = input.count { it[it.length - index - 1] == '1' }
            if (count < input.size / 2) {
                epsilon = epsilon or (1 shl index)
            } else {
                gamma = gamma or (1 shl index)
            }
        }

        return gamma * epsilon
    }

    fun solvePart2(): Int {
        val oxygenGeneratorRating = getRating(true)
        val cO2ScrubberRating = getRating(false)
        return oxygenGeneratorRating * cO2ScrubberRating
    }

    private fun getRating(largest: Boolean): Int {
        var list = input
        for (index in bitIndices) {
            if (list.size == 1) {
                break
            }

            val groups = list.groupBy { it[index] }
            val list0 = groups['0'] ?: emptyList()
            val list1 = groups['1'] ?: emptyList()

            list = if (list0.size <= list1.size == largest) {
                list1
            } else {
                list0
            }
        }
        return list.first().toInt(2)
    }
}
