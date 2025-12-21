package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput

class Day01(input: PuzzleInput) {
    val lines = input.readLines()
    var position = 50
    var count = 0

    fun solvePart1(): Int {
        for (line in lines) {
            val direction = if (line[0] == 'R') 1 else -1
            val steps = line.substring(1).toInt() * direction
            position = (position + steps).mod(100)
            if (position == 0) {
                count++
            }
        }
        return count
    }

    fun solvePart2(): Int {
        for (line in lines) {
            val direction = if (line[0] == 'R') 1 else -1
            val value = line.substring(1).toInt()
            val startedAtZero = position == 0
            count += value / 100
            position += value % 100 * direction

            if (position !in 1..<100) {
                position = position.mod(100)
                if (!startedAtZero) count++
            }
        }
        return count
    }
}
