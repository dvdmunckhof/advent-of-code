package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.splitOnce
import kotlin.math.max

class Day02(private val input: List<String>) {

    fun solvePart1(): Int = solve { gameId, cubes ->
        val valid = cubes.all { (count, color) ->
            when (color) {
                "red" -> count <= 12
                "green" -> count <= 13
                "blue" -> count <= 14
                else -> false
            }
        }

        if (valid) gameId else 0
    }

    fun solvePart2(): Int = solve { _, cubes ->
        val cubeMap = mutableMapOf("red" to 0, "green" to 0, "blue" to 0)

        for ((count, color) in cubes) {
            cubeMap[color] = max(count, cubeMap.getValue(color))
        }

        cubeMap.values.reduce {acc, i -> acc * i }
    }

    private fun solve(delegate: (gameId: Int, subsets: List<Pair<Int, String>>) -> Int): Int {
        return input.sumOf { line ->
            val colonIndex = line.indexOf(':', 6)
            val gameId = line.substring(5, colonIndex).toInt()

            val cubes = line.substring(colonIndex + 2)
                .split("; ", ", ")
                .map {
                    val (count, color) = it.splitOnce(" ")
                    count.toInt() to color
                }

            delegate(gameId, cubes)
        }
    }
}
