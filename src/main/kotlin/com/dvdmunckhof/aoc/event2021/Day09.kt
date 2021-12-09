package com.dvdmunckhof.aoc.event2021

class Day09(input: List<String>) {
    private val grid = input.map { row -> row.map(Char::digitToInt) }

    fun solvePart1(): Int {
        val results = grid.flatMapIndexed { x, row ->
            row.filterIndexed { y, height ->
                val north = x == 0 || grid[x - 1][y] > height
                val east = y == row.lastIndex || row[y + 1] > height
                val south = x == grid.lastIndex || grid[x + 1][y] > height
                val west = y == 0 || row[y - 1] > height
                north && east && south && west
            }
        }
        return results.sumOf { it + 1 }
    }

    fun solvePart2(): Int {
        error("No solution found")
    }
}
