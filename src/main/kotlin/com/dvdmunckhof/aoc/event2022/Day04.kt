package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.splitOnce
import com.dvdmunckhof.aoc.toRange

class Day04(private val input: List<String>) {

    fun solvePart1(): Int {
        return solve().count { (rangeA, rangeB) -> rangeA.contains(rangeB) || rangeB.contains(rangeA) }
    }

    fun solvePart2(): Int {
        return solve().count { (rangeA, rangeB) -> rangeA.overlaps(rangeB) || rangeB.overlaps(rangeA) }
    }

    private fun solve(): List<Pair<IntRange, IntRange>> {
        return input.map { pair ->
            val (partA, partB) = pair.splitOnce(",")
            partA.toRange() to partB.toRange()
        }
    }

    private fun IntRange.contains(other: IntRange): Boolean = this.contains(other.first) && this.contains(other.last)
    private fun IntRange.overlaps(other: IntRange): Boolean = this.contains(other.first) || this.contains(other.last)
}
