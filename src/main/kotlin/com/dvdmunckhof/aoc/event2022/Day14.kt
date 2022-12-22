package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.common.Point
import com.dvdmunckhof.aoc.splitOnce

class Day14(private val input: List<String>) {

    fun solvePart1() = solve(false)

    fun solvePart2() = solve(true)

    private fun solve(hasFloor: Boolean): Int {
        val grid = input.asSequence()
            .map { line ->
                line.split(" -> ").map { coordinate ->
                    val (x, y) = coordinate.splitOnce(",")
                    Point(x.toInt(), y.toInt())
                }
            }
            .flatMap { line -> line.windowed(2) }
            .flatMap { (pointA, pointB) -> pointA..pointB}
            .toMutableSet()

        val start = Point(500, 0)
        val maxY = grid.maxBy { it.y }.y + 2

        if (hasFloor) {
            for (x in (500 - maxY)..(500 + maxY)) {
                grid += Point(x, maxY)
            }
        }

        val directionsX = arrayOf(0, -1, 1)
        val initialSize = grid.size
        var point = start

        outer@while (point.y <= maxY) {
            for (directionX in directionsX) {
                val p = Point(point.x + directionX, point.y + 1)
                if (!grid.contains(p)) {
                    point = p
                    continue@outer
                }
            }

            grid += point

            if (point == start) {
                break@outer
            }

            point = start
        }

        return grid.size - initialSize
    }

    private operator fun Point.rangeTo(target: Point): Sequence<Point> = sequence {
        for (x in x toward target.x) {
            for (y in y toward target.y) {
                yield(Point(x, y))
            }
        }
    }

    private infix fun Int.toward(to: Int): IntProgression {
        val step = if (this > to) -1 else 1
        return IntProgression.fromClosedRange(this, to, step)
    }
}
