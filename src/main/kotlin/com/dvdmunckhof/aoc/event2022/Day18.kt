package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.common.Vector3d

class Day18(input: List<String>) {
    private val cubes = input.mapTo(mutableSetOf()) {
        val (x, y, z) = it.split(",").map(String::toInt)
        Vector3d(x, y, z)
    }

    private val neighbours = arrayOf(
        Vector3d(-1, 0, 0),
        Vector3d(1, 0, 0),
        Vector3d(0, -1, 0),
        Vector3d(0, 1, 0),
        Vector3d(0, 0, -1),
        Vector3d(0, 0, 1),
    )

    fun solvePart1(): Int {
        return cubes.sumOf { cube -> 6 - neighbours.count { offset -> (cube + offset) in cubes } }
    }

    fun solvePart2(): Int {
        val boundsX = -1..cubes.maxOf { it.x } + 1
        val boundsY = -1..cubes.maxOf { it.y } + 1
        val boundsZ = -1..cubes.maxOf { it.z } + 1

        var visibleSides = 0
        val processed = mutableSetOf<Vector3d>()
        val queue = ArrayDeque<Vector3d>()
        queue.add(Vector3d(-1, -1, -1))

        // Breadth-first search
        while (queue.isNotEmpty()) {
            val cube = queue.removeFirst()
            if (!processed.add(cube)) {
                continue
            }

            for (offset in neighbours) {
                val neighbour = cube + offset
                if (neighbour in cubes) {
                    visibleSides += 1
                } else if (neighbour.x in boundsX && neighbour.y in boundsY && neighbour.z in boundsZ) {
                    queue += neighbour
                }
            }
        }

        return visibleSides
    }
}
