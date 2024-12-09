package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import com.dvdmunckhof.aoc.common.splitAt

class Day05(input: PuzzleInput) {
    private val orderingRules: Map<Int, List<Int>>
    private val updates: List<List<Int>>

    init {
        val (chunkA, chunkB) = input.readString().splitAt("\n\n")
        orderingRules = chunkA.lines().map { it.splitAt("|") }
            .groupBy({ it.first.toInt() }) { it.second.toInt() }
        updates = chunkB.lines().map { it.split(",").map(String::toInt) }
    }

    fun solvePart1(): Int {
        return updates.filter(::isOrdered).sumOf { it[it.size / 2] }
    }

    fun solvePart2(): Int {
        return updates.filterNot(::isOrdered).map(::reorder).sumOf { it[it.size / 2] }
    }

    private fun isOrdered(update: List<Int>): Boolean {
        val processed = HashSet<Int>(update.size)
        for (page in update) {
            processed += page
            val requirements = orderingRules[page] ?: continue
            if (requirements.any { it in processed }) {
                return false
            }
        }
        return true
    }

    private tailrec fun reorder(input: List<Int>): List<Int> {
        val result = ArrayList<Int>(input.size)
        val processed = HashSet<Int>(input.size)
        var reordered = false

        for (n in input) {
            processed += n
            result += n
            val requirements = orderingRules[n] ?: continue
            for (r in requirements) {
                if (r in processed) {
                    result.remove(r)
                    result += r
                    reordered = true
                }
            }
        }

        return if (reordered) reorder(result) else result
    }
}
