package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput

class Day07(input: PuzzleInput) {
    private val lines = input.readLines()
    private val startCol = lines[0].indexOfFirst { it == 'S' }

    fun solvePart1(row: Int = 0, beams: Set<Int> = setOf(startCol)): Int {
        if (row == lines.lastIndex) {
            return 0
        }

        val newBeams = mutableSetOf<Int>()
        val line = lines[row]
        var splits = 0

        for (col in beams) {
            if (line[col] == '^') {
                splits++
                newBeams += col - 1
                newBeams += col + 1
            } else {
                newBeams += col
            }
        }

        return splits + solvePart1(row + 1, newBeams)
    }

    fun solvePart2(): Long {
        val startLine = lines[0].map { if (it == 'S') 1L else 0L }
        return solve(1, startLine)
    }

    private tailrec fun solve(row: Int, beams: List<Long>): Long {
        if (row == lines.size) {
            return beams.sum()
        }

        val list = MutableList(beams.size) { 0L }
        for ((col, value) in beams.withIndex()) {
            if (value == 0L) continue

            if (lines[row][col] == '^') {
                list[col - 1] += value
                list[col + 1] += value
            } else {
                list[col] += value
            }
        }

        return solve(row + 1, list)
    }
}
