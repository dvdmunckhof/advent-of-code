package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.Point
import com.dvdmunckhof.aoc.common.PuzzleInput

class Day08(input: PuzzleInput) {
    val grid = input.readCharGrid()

    fun solvePart1(): Int {
        return findAntiNodes { antennaA, antennaB, delta ->
            listOf(antennaA - delta, antennaB + delta).filter { it in grid }
        }
    }

    fun solvePart2(): Int {
        return findAntiNodes { antennaA, antennaB, delta ->
            val result = mutableListOf<Point>(antennaA, antennaB)

            var antiNode = antennaA - delta
            while (antiNode in grid) {
                result += antiNode
                antiNode -= delta
            }

            antiNode = antennaB + delta
            while (antiNode in grid) {
                result += antiNode
                antiNode += delta
            }
            result
        }
    }

    private fun findAntiNodes(transform: (antennaA: Point, antennaB: Point, delta: Point) -> List<Point>): Int {
        val antennas = grid.points().filter { grid[it] != '.' }.groupBy { grid[it] }
        val antiNodes = mutableSetOf<Point>()

        for (locations in antennas.values) {
            for (i in locations.indices) {
                for (j in i+1..locations.lastIndex) {
                    val antennaA = locations[i]
                    val antennaB = locations[j]
                    val delta = antennaB - antennaA
                    antiNodes += transform(locations[i], locations[j], delta)
                }
            }
        }

        return antiNodes.size
    }
}
