package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.Grid
import com.dvdmunckhof.aoc.common.Point
import com.dvdmunckhof.aoc.common.PuzzleInput

class Day16(val input: PuzzleInput) {

    fun solvePart1(): Int {
        val grid = input.readCharGrid()
        val startPoint = grid.indexToPoint(grid.indexOf('S'))
        val endPoint = grid.indexToPoint(grid.indexOf('E'))
        val walls = Grid(grid.rows.map { row -> row.map { it == '#' } })
        val results = Grid(grid.width, grid.height) { Array(4) { Int.MAX_VALUE } }
        results[startPoint][Direction.EAST.ordinal] = 0

        val queue = ArrayDeque(listOf(startPoint to Direction.EAST))

        while (queue.isNotEmpty()) {
            val (point, direction) = queue.removeFirst()
            val score = results[point][direction.ordinal]

            val pointStraight = point + direction.offset
            val pointLeft = point + direction.left.offset
            val pointRight = point + direction.right.offset

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

        return results[endPoint].min()
    }

    fun solvePart2(): Int {
        error("No solution found")
    }

    private enum class Direction(val offset: Point) {
        NORTH(Point(-1, 0)),
        EAST(Point(0, 1)),
        SOUTH(Point(1, 0)),
        WEST(Point(0, -1));

        val left by lazy { entries[(this.ordinal + 3) % 4] }
        val right by lazy { entries[(this.ordinal + 1) % 4] }
    }
}
