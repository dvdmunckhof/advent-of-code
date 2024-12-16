package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.Grid
import com.dvdmunckhof.aoc.common.Point
import com.dvdmunckhof.aoc.common.PuzzleInput

class Day04(input: PuzzleInput) {
    private val grid = input.readCharGrid()

    fun solvePart1(): Int {
        val directionOffsets = Grid.DIRECTION_OFFSETS_HVD
            .map { point -> listOf('M' to point, 'A' to point * 2, 'S' to point * 3) }

        return grid.points().sumOf { point ->
            if (grid[point] != 'X') {
                return@sumOf 0
            }

            directionOffsets.count { charOffsets ->
                charOffsets.all { (char, offset) ->
                    val p = point + offset
                    p in grid && grid[p] == char
                }
            }
        }
    }

    fun solvePart2(): Int {
        return grid.points().count { point ->
            grid[point] == 'A' && findMS(point, Point(-1, -1)) && findMS(point, Point(-1, 1))
        }
    }

    private fun findMS(point: Point, offset: Point): Boolean {
        val pointA = point + offset
        val pointB = point - offset
        if (pointA !in grid || pointB !in grid) {
            return false
        }

        val a = grid[pointA]
        val b = grid[pointB]
        return (a == 'M' && b == 'S') || (b == 'M' && a == 'S')
    }
}
