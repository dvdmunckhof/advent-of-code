package com.dvdmunckhof.aoc.event2021

class Day09(input: List<String>) {
    private val grid = input.map { row -> row.map(Char::digitToInt) }

    fun solvePart1(): Int {
        val directions = Direction.values().toMutableList()
        val results = grid.flatMapIndexed { x, row ->
            val rowDirections = when(x) {
                0 -> directions - Direction.NORTH
                grid.lastIndex -> directions - Direction.SOUTH
                else -> directions
            }
            row.filterIndexed { y, height ->
                val locationDirections = when (y) {
                    0 -> rowDirections - Direction.WEST
                    row.lastIndex -> rowDirections - Direction.EAST
                    else -> rowDirections
                }
                locationDirections.all { d -> grid[x + d.north][y + d.east] > height }
            }
        }
        return results.sumOf { it + 1 }
    }

    fun solvePart2(): Int {
        error("No solution found")
    }

    private enum class Direction(val north: Int, val east: Int) {
        NORTH(-1, 0), EAST(0, 1), SOUTH(1, 0), WEST(0, -1);
    }
}
