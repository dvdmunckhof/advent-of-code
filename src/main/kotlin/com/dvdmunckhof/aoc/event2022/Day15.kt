package com.dvdmunckhof.aoc.event2022

import kotlin.math.abs
import kotlin.math.max

class Day15(private val input: List<String>) {
    private val sensors = parseSensors()

    fun solvePart1(targetY: Int): Int {
        val range = coveredRange(targetY)
        return range.last - range.first
    }

    fun solvePart2(maxRange: Int): Long {
        for (y in 0..maxRange) {
            try {
                coveredRange(y)
            } catch (e: RangeException) {
                return e.x * 4_000_000L + y
            }
        }
        error("No solution found")
    }

    private fun coveredRange(targetY: Int): IntRange {
        return sensors
            .mapNotNull { it.coveredRange(targetY) }
            .sortedWith { a, b ->
                if (a.first == b.first) {
                    a.last.compareTo(b.last)
                } else {
                    a.first.compareTo(b.first)
                }
            }
            .reduce { a, b ->
                if (a.last + 1 < b.first) {
                    throw RangeException(a.last + 1)
                }

                // merge ranges
                a.first..max(a.last, b.last)
            }
    }

    private fun parseSensors(): List<Sensor> {
        val numberRegex = Regex("-?\\d+")
        return input.map { line ->
            val (sensorX, sensorY, beaconX, beaconY) = numberRegex.findAll(line)
                .map { it.groupValues.first().toInt() }
                .toList()

            Sensor(sensorX, sensorY, beaconX, beaconY)
        }
    }

    private data class Sensor(val x: Int, val y: Int, val beaconX: Int, val beaconY: Int) {
        val distanceBeacon = abs(x - beaconX) + abs(y - beaconY)

        fun coveredRange(targetY: Int): IntRange? {
            val distanceTarget = abs(y - targetY)
            val deltaBeaconX = distanceBeacon - distanceTarget
            if (deltaBeaconX < 0) {
                return null
            }
            return (x - deltaBeaconX)..(x + deltaBeaconX)
        }
    }

    private class RangeException(val x: Int) : Exception("Gap in range: $x")
}
