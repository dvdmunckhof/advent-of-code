package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.Point
import com.dvdmunckhof.aoc.common.PuzzleInput
import kotlin.Triple

class Day06(input: PuzzleInput) {
    private val grid = input.readCharGrid()
    private val startPoint = grid.indexToPoint(grid.indexOf('^'))

    fun solvePart1(): Int {
        return walk().size
    }

    fun solvePart2(): Int {
        return walk().count { obstruction ->
            val turningPoints = mutableSetOf<Triple<Int, Int, Int>>()
            var position = startPoint
            var direction = Direction.NORTH

            while (true) {
                val nextPos = position.walk(direction)
                if (nextPos !in grid) {
                    break
                }
                if (grid[nextPos] == '#' || nextPos == obstruction) {
                    direction = direction.right
                    if (!turningPoints.add(Triple(position.r, position.c, direction.ordinal))) {
                        return@count true
                    }
                } else {
                    position = nextPos
                }
            }
            false
        }
    }

    private fun walk(): Set<Point> {
        val positions = mutableSetOf(startPoint)
        var position = startPoint
        var direction = Direction.NORTH

        while (true) {
            val nextPos = position.walk(direction)
            if (nextPos !in grid) {
                break
            }

            if (grid[nextPos] == '#') {
                direction = direction.right
            } else {
                positions += nextPos
                position = nextPos
            }
        }
        return positions
    }

    private enum class Direction(val offset: Point) {
        NORTH(Point(-1, 0)),
        EAST(Point(0, 1)),
        SOUTH(Point(1, 0)),
        WEST(Point(0, -1));

        val left by lazy { entries[(this.ordinal + 3) % 4] }
        val right by lazy { entries[(this.ordinal + 1) % 4] }
    }

    private fun Point.walk(direction: Direction): Point = this + direction.offset
}
