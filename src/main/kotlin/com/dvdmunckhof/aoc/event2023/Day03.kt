package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.size
import java.util.ArrayList
import kotlin.math.max
import kotlin.math.min

class Day03(private val input: List<String>) {

    fun solvePart1(): Int {
        val regex = Regex("\\d+")
        return input.withIndex().sumOf { (index, line) ->
            regex.findAll(line)
                .filter { hasAdjacentSymbol(index, it.range) }
                .sumOf { it.value.toInt() }
        }
    }

    fun solvePart2(): Int {
        val gearMap = mutableMapOf<Pair<Int, Int>, MutableList<Int>>()

        val regex = Regex("\\d+")
        for ((index, line) in input.withIndex()) {
            for (match in regex.findAll(line)) {
                for (point in adjacentPoints(index, match.range)) {
                    if (input[point.first][point.second] == '*') {
                        gearMap.getOrPut(point, ::mutableListOf) += match.value.toInt()
                    }
                }
            }
        }

        return gearMap.values.filter { it.size == 2 }.sumOf { it[0] * it[1] }
    }

    private fun adjacentPoints(lineIndex: Int, range: IntRange): List<Pair<Int, Int>> {
        val adjacentRange = max(0, range.first - 1)..min(range.last + 1, input[lineIndex].lastIndex)
        val list = ArrayList<Pair<Int, Int>>(2 * range.size + 6)

        if (lineIndex > 0) {
            adjacentRange.mapTo(list) { i -> lineIndex - 1 to i }
        }

        if (lineIndex < input.lastIndex) {
            adjacentRange.mapTo(list) { i -> lineIndex + 1 to i }
        }

        if (range.first != adjacentRange.first) {
            list += lineIndex to adjacentRange.first
        }

        if (range.last != adjacentRange.last) {
            list += lineIndex to adjacentRange.last
        }

        return list
    }

    private fun hasAdjacentSymbol(lineIndex: Int, range: IntRange): Boolean {
        return adjacentPoints(lineIndex, range).any { (i, j) ->
            val c = input[i][j]
            c !in '0'..'9' && c != '.'
        }
    }
}
