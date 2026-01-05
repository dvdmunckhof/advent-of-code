package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import com.dvdmunckhof.aoc.common.multiply

class Day08(input: PuzzleInput) {
    private val vectors = input.readLines().map {
        val (x, y, z) = it.split(",")
        Vector3D(x.toLong(), y.toLong(), z.toLong())
    }
    private val combinations = vectors
        .pairCombinations()
        .sortedBy { (a, b) ->
            val dx = a.x - b.x
            val dy = a.y - b.y
            val dz = a.z - b.z
            dx * dx + dy * dy + dz * dz
        }
    private val circuitMap = mutableMapOf<Vector3D, MutableList<Vector3D>>()

    fun solvePart1(connections: Int): Int {
        for ((vectorA, vectorB) in combinations.take(connections)) {
            createConnection(vectorA, vectorB)
        }

        return circuitMap.values
            .distinct()
            .map { it.size }
            .sortedDescending()
            .take(3)
            .multiply()
    }

    fun solvePart2(): Long {
        for ((vectorA, vectorB) in combinations) {
            createConnection(vectorA, vectorB)

            if (circuitMap[vectorA]!!.size == vectors.size) {
                return vectorA.x * vectorB.x
            }
        }

        error("No solution found")
    }

    private fun createConnection(vectorA: Vector3D, vectorB: Vector3D) {
        val circuitA = circuitMap[vectorA]
        val circuitB = circuitMap[vectorB]

        if (circuitA == null) {
            if (circuitB == null) {
                // neither is connected -> create new circuit
                val circuit = mutableListOf(vectorA, vectorB)
                circuitMap[vectorA] = circuit
                circuitMap[vectorB] = circuit
            } else {
                // B is connected, A isn't -> add A to B
                circuitB += vectorA
                circuitMap[vectorA] = circuitB
            }
        } else if (circuitB == null) {
            // A is connected, B isn't -> add B to A
            circuitA += vectorB
            circuitMap[vectorB] = circuitA
        } else if (circuitA !== circuitB) {
            // both are connected to different circuits -> merge circuits
            circuitA += circuitB

            for (vector in circuitB) {
                circuitMap[vector] = circuitA
            }
        }
    }

    private fun <T> List<T>.pairCombinations(): Sequence<Pair<T, T>> = sequence {
        for (i in 0..<lastIndex) {
            for (j in i + 1..lastIndex) {
                yield(get(i) to get(j))
            }
        }
    }

    private data class Vector3D(val x: Long, val y: Long, val z: Long)
}
