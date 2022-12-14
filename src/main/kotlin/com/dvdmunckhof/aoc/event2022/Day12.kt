package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.common.Grid
import com.dvdmunckhof.aoc.common.Point
import com.dvdmunckhof.aoc.toGrid
import java.util.ArrayDeque

class Day12(input: List<String>) {
    private val heightGrid = input.map { row -> row.map { c ->
        when (c) {
            'S' -> -1
            'E' -> 25
            else -> c - 'a'
        }
    }}.toGrid()

    fun solvePart1(): Int {
        val startIndex = heightGrid.indexOfFirst { it == -1 }
        val startPoint = heightGrid.indexToPoint(startIndex)
        return solve(startPoint)
    }

    fun solvePart2(): Int {
        return heightGrid.points()
            .filter { p -> heightGrid[p] <= 0 }
            .minOf { solve(it) }
    }

    private fun solve(startPoint: Point): Int {
        val stepGrid = Grid<Int?>(heightGrid.width, heightGrid.height, null)
        stepGrid[startPoint] = 0
        heightGrid[startPoint] = 0

        val queue = ArrayDeque<Point>()
        queue += startPoint

        while (queue.isNotEmpty()) {
            val point = queue.removeFirst()
            val step = stepGrid[point]!!
            val height = heightGrid[point]

            val neighbors = heightGrid.adjacent(point, false)
            for (neighbor in neighbors) {
                if (stepGrid[neighbor] != null) {
                    continue
                }

                val neighborValue = heightGrid[neighbor]
                if (neighborValue - 1 <= height) {
                    if (height == 25) {
                        return step + 1
                    }
                    stepGrid[neighbor] = step + 1
                    queue += neighbor
                }
            }
        }
        return Int.MAX_VALUE
    }
}
