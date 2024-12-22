package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.*

class Day14(input: PuzzleInput, private val spaceWidth: Int, private val spaceHeight: Int) {
    private val robots: List<Pair<Point, Point>>

    init {
        val regex = Regex("p=(-?\\d+),(-?\\d+) v=(-?\\d+),(-?\\d+)")
        robots = regex.findAll(input.readString()).map { match ->
            val (startH, startV, velocityH, velocityV) = match.groupValues.drop(1).map(String::toInt)
            Point(startV, startH) to Point(velocityV, velocityH)
        }.toList()
    }

    fun solvePart1(): Int {
        val centerH = spaceWidth / 2
        val centerV = spaceHeight / 2
        return solve(100).mapNotNull { (posV, posH) ->
            when {
                posH < centerH && posV < centerV -> 1
                posH > centerH && posV < centerV -> 2
                posH < centerH && posV > centerV -> 3
                posH > centerH && posV > centerV -> 4
                else -> null
            }
        }
            .groupCount()
            .values
            .multiply()
    }

    fun solvePart2(): Int {
        var i = 1
        while (true) {
            val locations = solve(i)
            val set = locations.toSet()
            if (set.size == locations.size) {
                val isMatch = locations.any { loc -> Grid.DIRECTION_OFFSETS_HVD.all { offset -> loc + offset in set } }
                if (isMatch) {
                    return i
                }
            }
            i++
        }
    }

    private fun solve(steps: Int): List<Point> {
        return robots.map { (start, velocity) ->
            val posH = (start.c + velocity.c * steps).mod(spaceWidth)
            val posV = (start.r + velocity.r * steps).mod(spaceHeight)
            Point(posV, posH)
        }
    }
}
