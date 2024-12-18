package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.Grid
import com.dvdmunckhof.aoc.common.Point
import com.dvdmunckhof.aoc.common.PuzzleInput

class Day12(input: PuzzleInput) {
    private val gridInput = input.readCharGrid()
    private val gridProcessed = Grid(gridInput.width, gridInput.height, false)
    private val cornerOffsetsList = arrayOf(
        arrayOf(Point(0, 1), Point(1, 1), Point(1, 0)),
        arrayOf(Point(1, 0), Point(1, -1), Point(0, -1)),
        arrayOf(Point(0, -1), Point(-1, -1), Point(-1, 0)),
        arrayOf(Point(-1, 0), Point(-1, 1), Point(0, 1)),
    )

    fun solvePart1(): Int {
        return gridInput.points().filterNot { gridProcessed[it] }.sumOf { point ->
            val region = RegionPerimeter(gridInput[point], 0, 0)
            processPerimeter(region, point)
            region.perimeter * region.area
        }
    }

    private fun processPerimeter(region: RegionPerimeter, point: Point) {
        gridProcessed[point] = true
        region.area++

        for (offset in Grid.DIRECTION_OFFSETS_HV) {
            val neighbor = point + offset
            if (neighbor !in gridInput || gridInput[neighbor] != region.value) {
                region.perimeter++
                continue
            }

            if (gridProcessed[neighbor]) {
                continue
            }

            processPerimeter(region, neighbor)
        }
    }

    fun solvePart2(): Int {
        return gridInput.points().filterNot { gridProcessed[it] }.sumOf { point ->
            val region = RegionSides(gridInput[point], 0, 0)
            processSides(region, point)
            region.sides * region.area
        }
    }

    private fun processSides(region: RegionSides, point: Point) {
        gridProcessed[point] = true
        region.area++

        for (cornerOffsets in cornerOffsetsList) {
            val cornerPoints = cornerOffsets.map { offset -> point + offset }
            val matches = cornerPoints.map { it in gridInput && gridInput[it] == region.value }

            if ((!matches[0] && !matches[2]) || (matches[0] && !matches[1] && matches[2])) {
                region.sides++
            }

            if (matches[0] && !gridProcessed[cornerPoints[0]]) {
                processSides(region, cornerPoints[0])
            }
        }
    }

    private data class RegionPerimeter(val value: Char, var area: Int, var perimeter: Int)
    private data class RegionSides(val value: Char, var area: Int, var sides: Int)
}
