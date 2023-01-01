package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.common.Point
import kotlin.math.abs

class Day09(private val input: List<String>) {

    fun solvePart1() = solve(1)

    fun solvePart2() = solve(9)

    private fun solve(n: Int): Int {
        val knots = MutableList(n + 1) { Point(0, 0) }
        val positions = mutableSetOf(knots[n])

        for (line in input) {
            val distance = line.substring(2).toInt()
            val direction = when (line[0]) {
                'U' -> Point(0, 1)
                'R' -> Point(1, 0)
                'D' -> Point(0, -1)
                'L' -> Point(-1, 0)
                else -> error("Invalid direction")
            }

            repeat(distance) {
                knots[0] += direction

                for (i in 1..n) {
                    val front = knots[i-1]
                    val knot = knots[i]
                    val deltaR = front.r - knot.r
                    val deltaC = front.c - knot.c

                    if (abs(deltaR) > 1 || abs(deltaC) > 1) {
                        knots[i] += Point(deltaR.coerceIn(-1, 1), deltaC.coerceIn(-1, 1))
                        if (i == n) {
                            positions += knots[i]
                        }
                    }
                }
            }
        }

        return positions.size
    }
}
