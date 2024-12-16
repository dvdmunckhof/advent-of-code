package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.Point
import com.dvdmunckhof.aoc.common.PuzzleInput

class Day10(input: PuzzleInput) {
    private val grid = input.readDigitGrid()
    private val startPoints = grid.points().filter { grid[it] == 0 }

    fun solvePart1(): Int = startPoints.sumOf { solve(it, true) }

    fun solvePart2(): Int = startPoints.sumOf { solve(it, false) }

    private fun solve(start: Point, unique: Boolean): Int {
        val queue = ArrayDeque(listOf(start))
        val results: MutableCollection<Point> = if (unique) mutableSetOf() else mutableListOf()

        while (queue.isNotEmpty()) {
            val point = queue.removeFirst()
            val value = grid[point]

            if (value == 9) {
                results += point
            } else {
                grid.adjacent(point).filterTo(queue) { grid[it] == value + 1 }
            }
        }

        return results.size
    }
}
