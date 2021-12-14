package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.common.Grid
import com.dvdmunckhof.aoc.common.Point

class Day11(input: List<String>) {
    private val grid = Grid(input.map { it.map(Char::digitToInt) })

    fun solvePart1(): Int = (1..100).sumOf { step() }

    fun solvePart2(): Int = generateSequence(1, Int::inc).first { step() == grid.size }

    private fun step(): Int {
        grid.forEach(::increment)
        val flashes = grid.filter { point -> grid[point] >= 10 }
        flashes.forEach { point -> grid[point] = 0 }
        return flashes.size
    }

    private fun increment(point: Point) {
        val value = grid[point] + 1
        grid[point] = value

        if (value == 10) {
            grid.adjacent(point).forEach(::increment)
        }
    }
}
