package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.Direction
import com.dvdmunckhof.aoc.common.Grid
import com.dvdmunckhof.aoc.common.PuzzleInput
import com.dvdmunckhof.aoc.common.move

class Day16(input: PuzzleInput) {
    private val grid = input.readCharGrid()
    private val startPoint = grid.indexToPoint(grid.indexOf('S'))
    private val endPoint = grid.indexToPoint(grid.indexOf('E'))
    private val walls = Grid(grid.rows.map { row -> row.map { it == '#' } })

    fun solvePart1(): Int {
        return solve()[endPoint].min()
    }

    fun solvePart2(): Int {
        val grid = solve()
        val endScore = grid[endPoint].min()
        val results = mutableSetOf(endPoint)
        val queue = grid[endPoint].withIndex()
            .filter { it.value == endScore }
            .mapTo(mutableListOf()) { endPoint to Direction.entries[it.index] }

        while (queue.isNotEmpty()) {
            val (point, direction) = queue.removeLast()
            val score = grid[point][direction.ordinal]
            val previousPoint = point - direction.offset
            val previousScores = grid[previousPoint]

            if (previousScores[direction.ordinal] + 1 == score) {
                results += previousPoint
                queue += previousPoint to direction
            }

            if (previousScores[direction.left.ordinal] + 1001 == score) {
                results += previousPoint
                queue += previousPoint to direction.left
            }

            if (previousScores[direction.right.ordinal] + 1001 == score) {
                results += previousPoint
                queue += previousPoint to direction.right
            }
        }

        return results.size
    }

    private fun solve(): Grid<Array<Int>> {
        val results = Grid(grid.width, grid.height) { Array(4) { Int.MAX_VALUE } }
        results[startPoint][Direction.EAST.ordinal] = 0

        val queue = ArrayDeque(listOf(startPoint to Direction.EAST))

        while (queue.isNotEmpty()) {
            val (point, direction) = queue.removeFirst()
            val score = results[point][direction.ordinal]

            val pointStraight = point.move(direction)
            val pointLeft = point.move(direction.left)
            val pointRight = point.move(direction.right)

            if (pointStraight in grid && !walls[pointStraight] && score + 1 < results[pointStraight][direction.ordinal]) {
                results[pointStraight][direction.ordinal] = score + 1
                queue += pointStraight to direction
            }

            if (pointLeft in grid && !walls[pointLeft] && score + 1001 < results[pointLeft][direction.left.ordinal]) {
                results[pointLeft][direction.left.ordinal] = score + 1001
                queue += pointLeft to direction.left
            }

            if (pointRight in grid && !walls[pointRight] && score + 1001 < results[pointRight][direction.right.ordinal]) {
                results[pointRight][direction.right.ordinal] = score + 1001
                queue += pointRight to direction.right
            }
        }

        return results
    }
}
