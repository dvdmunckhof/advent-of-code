package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.common.Grid
import com.dvdmunckhof.aoc.common.Point

class Day11(input: List<List<Int>>) {
    private val grid = Grid(input)

    fun solvePart1(): Int = (1..100).sumOf { step() }

    fun solvePart2(): Int = generateSequence(1, Int::inc).first { step() == grid.size }

    private fun step(): Int {
        grid.points().forEach(::increment)
        return grid.points().count { point ->
            val flashes = grid[point] >= 10
            if (flashes) {
                grid[point] = 0
            }
            flashes
        }
    }

    private fun increment(point: Point) {
        val value = grid[point] + 1
        grid[point] = value

        if (value == 10) {
            grid.adjacent(point).forEach(::increment)
        }
    }
}
