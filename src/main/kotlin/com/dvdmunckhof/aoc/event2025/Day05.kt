package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import com.dvdmunckhof.aoc.common.size
import com.dvdmunckhof.aoc.common.splitAt
import com.dvdmunckhof.aoc.common.toRange

class Day05(input: PuzzleInput) {
    val freshIngredients: List<LongRange>
    val ingredientIds: List<Long>

    init {
        val (block1, block2) = input.readString().splitAt("\n\n")
        freshIngredients = block1.lines().map(String::toRange)
        ingredientIds = block2.lines().map(String::toLong)
    }

    fun solvePart1(): Int = ingredientIds.count { ingredient -> freshIngredients.any { range -> ingredient in range } }

    fun solvePart2(): Long {
        var count = 0L
        var highest = 0L

        for (range in freshIngredients.sortedBy { it.first }) {
            // range fully overlaps
            if (range.last <= highest) continue

            // partial overlap OR no overlap
            count += if (range.first <= highest) range.last - highest else range.size

            highest = range.last
        }

        return count
    }
}
