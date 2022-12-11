package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.common.Grid
import com.dvdmunckhof.aoc.common.Point

class Day15(private val input: List<List<Int>>) {

    fun solvePart1(): Int {
        return solve(Grid(input))
    }

    fun solvePart2(): Int {
        val multipliedH = input.map { row -> repeatList(row, 5) { level, i -> incrementLevel(level, i) } }
        val multipliedV = repeatList(multipliedH, 5) { row, i -> row.map { level -> incrementLevel(level, i) } }
        return solve(Grid(multipliedV))
    }

    private fun <R> repeatList(list: List<R>, n: Int, transform: (R, Int) -> R): List<R> {
        val result = list.toMutableList()
        for (i in 1 until n) {
            result += list.map { r -> transform(r, i) }
        }
        return result
    }

    private fun incrementLevel(level: Int, i: Int): Int = (level + i - 1).mod(9) + 1

    private fun solve(riskGrid: Grid<Int>): Int {
        val pathGrid = Grid(riskGrid.width, riskGrid.height, Int.MAX_VALUE)
        val startPoint = Point(0, 0)
        var changed = true

        while (changed) {
            changed = false

            for (p in pathGrid.points()) {
                if (p == startPoint) {
                    pathGrid[p] = 0
                    continue
                }

                val points = pathGrid.adjacent(p, false)
                val value = points.minOf { pathGrid[it] } + riskGrid[p]
                if (value != pathGrid[p]) {
                    changed = true
                    pathGrid[p] = value
                }
            }
        }

        return pathGrid.rows.last().last()
    }
}
