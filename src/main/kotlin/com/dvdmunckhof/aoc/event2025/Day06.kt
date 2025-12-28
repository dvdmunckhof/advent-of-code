package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import com.dvdmunckhof.aoc.common.multiply

class Day06(private val input: PuzzleInput) {

    fun solvePart1() = solve { lines, range -> lines.map { it.substring(range).trim().toLong() } }

    fun solvePart2() = solve { lines, range ->
        range
            .map { i ->
                lines.map { line -> line[i] }
                    .filter { it != ' ' }
                    .joinToString("")
            }
            .filter { it.isNotEmpty() }
            .map { it.toLong() }
    }

    private fun solve(numberInRange: (lines: List<String>, range: IntRange) -> List<Long>): Long {
        val lines = input.readLines()
        val numberLines = lines.dropLast(1)

        return Regex("[*+] *")
            .findAll(lines.last())
            .sumOf { match ->
                val numbers = numberInRange(numberLines, match.range)
                if (match.value.startsWith('+')) numbers.sum() else numbers.multiply()
            }
    }
}
