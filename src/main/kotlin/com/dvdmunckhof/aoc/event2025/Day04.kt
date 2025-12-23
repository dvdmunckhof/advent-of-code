package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput

class Day04(input: PuzzleInput) {
    val grid = input.readGrid { c -> c == '@' }

    fun solvePart1(): Int = grid.points().count { p -> grid[p] && grid.adjacent(p, true).count { grid[it] } < 4 }

    fun solvePart2(): Int {
        val queue = ArrayDeque(grid.points().toList())
        var count = 0

        while (queue.isNotEmpty()) {
            val point = queue.removeFirst()
            if (!grid[point]) continue

            val adjacent = grid.adjacent(point, true).filter { p -> grid[p] }
            if (adjacent.size < 4) {
                grid[point] = false
                count++
                queue.addAll(adjacent)
            }
        }
        return count
    }
}
