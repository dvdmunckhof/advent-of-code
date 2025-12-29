package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput

class Day07(input: PuzzleInput) {
    private val lines = input.readLines()
    private val startCol = lines[0].indexOfFirst { it == 'S' }
    private val cache = Array(lines.size) { mutableMapOf<Int, Long>() }

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

    fun solvePart2(row: Int = 0, col: Int = startCol): Long {
        if (row == lines.lastIndex) {
            return 1L
        }

        return cache[row].computeIfAbsent(col) {
            if (lines[row][col] == '^') {
                solvePart2(row + 1, col - 1) + solvePart2(row + 1, col + 1)
            } else {
                solvePart2(row + 1, col)
            }
        }
    }
}
