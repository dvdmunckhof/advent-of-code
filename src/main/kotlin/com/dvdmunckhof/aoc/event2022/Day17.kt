package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.common.MutableBitSet
import com.dvdmunckhof.aoc.common.Point

class Day17(input: String, shapesInput: String) {
    private val directions = input.map { c -> Direction.values().first { it.c == c } }
    private val rocks = shapesInput.split("\n\n").map { block -> parseRock(block.lines()) }

    fun solvePart1() = solve(2022)

    fun solvePart2() = solve(1_000_000_000_000L)

    private fun solve(targetStep: Long): Long {
        val cave = Cave(7)
        var step = 0
        val states = mutableMapOf<State, Pair<Int, Int>>()

        while (true) {
            val rock = rocks[step++ % rocks.size]
            cave.dropRock(rock)

            val state = cave.state()
            if (state !in states) {
                states[state] = step to cave.height
                continue
            }

            val (prefixStep, prefixHeight) = states.getValue(state)
            val patternSteps = step - prefixStep
            val patternHeight = cave.height - prefixHeight
            val remainingSteps = targetStep - step

            if (remainingSteps % patternSteps == 0L) {
                val patternCount = remainingSteps / patternSteps
                return cave.height + patternCount * patternHeight
            }
        }
    }

    private inner class Cave(val width: Int) {
        private val grid = mutableListOf<MutableBitSet>()
        private var directionIndex = -1
        val height: Int
            get() = grid.size

        fun dropRock(rock: Rock) {
            val startPosition = Point(this.height + 3, 2)
            val position = dropRockDirection(rock, startPosition, false)

            for (offset in rock.points) {
                this.set(position.r + offset.r, position.c + offset.c)
            }
        }

        private fun dropRockDirection(rock: Rock, position: Point, down: Boolean): Point {
            val direction = if (down) {
                Direction.DOWN
            } else {
                directionIndex = (directionIndex + 1) % directions.size
                directions[directionIndex]
            }
            val positionNew = position + direction.offset

            return if (isValidPosition(rock, positionNew)) {
                dropRockDirection(rock, positionNew, !down)
            } else if (!down) {
                dropRockDirection(rock, position, true)
            } else {
                position
            }
        }

        private fun isValidPosition(rock: Rock, position: Point): Boolean {
            if (position.r < 0 || position.c < 0 || position.c + rock.width > this.width) {
                return false
            }

            return rock.points.none { offset -> this.get(position.r + offset.r, position.c + offset.c) }
        }

        private fun get(r: Int, c: Int): Boolean {
            return if (r < grid.size) grid[r][c] else false
        }

        private fun set(r: Int, c: Int) {
            while (grid.lastIndex < r) {
                grid += MutableBitSet()
            }
            grid[r][c] = true
        }

        fun state(): State {
            val hash = grid.takeLast(2).foldIndexed(0L) { i, acc, bitSet -> acc or (bitSet.value shl (i * width)) }
            return State(this.directionIndex, hash)
        }
    }

    private fun parseRock(lines: List<String>): Rock {
        val points = lines
            .reversed()
            .flatMapIndexed { r, line ->
                line.mapIndexedNotNull { c, char ->
                    if (char == '#') Point(r, c) else null
                }
            }
        return Rock(points, lines.first().length, lines.size)
    }

    private data class Rock(val points: List<Point>, val width: Int, val height: Int)

    private enum class Direction(val c: Char, val offset: Point) {
        LEFT('<', Point(0, -1)),
        RIGHT('>', Point(0, 1)),
        DOWN('>', Point(-1, 0)),
    }

    private data class State(val direction: Int, val gridHash: Long)
}
