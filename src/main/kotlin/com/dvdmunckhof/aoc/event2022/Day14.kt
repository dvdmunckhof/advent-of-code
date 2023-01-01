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
                    val (r, c) = coordinate.splitOnce(",")
                    Point(r.toInt(), c.toInt())
                }
            }
            .flatMap { line -> line.windowed(2) }
            .flatMap { (pointA, pointB) -> pointA..pointB}
            .toMutableSet()

        val start = Point(500, 0)
        val maxC = grid.maxBy { it.c }.c + 2

        if (hasFloor) {
            for (r in (500 - maxC)..(500 + maxC)) {
                grid += Point(r, maxC)
            }
        }

        val directionsC = arrayOf(0, -1, 1)
        val initialSize = grid.size
        var point = start

        outer@while (point.c <= maxC) {
            for (directionR in directionsC) {
                val p = Point(point.r + directionR, point.c + 1)
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
        for (r in r toward target.r) {
            for (c in c toward target.c) {
                yield(Point(r, c))
            }
        }
    }

    private infix fun Int.toward(to: Int): IntProgression {
        val step = if (this > to) -1 else 1
        return IntProgression.fromClosedRange(this, to, step)
    }
}
