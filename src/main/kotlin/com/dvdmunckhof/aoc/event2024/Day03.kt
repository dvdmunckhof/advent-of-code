package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput

class Day03(private val input: PuzzleInput) {

    fun solvePart1(): Int {
        return Regex("mul\\((\\d+),(\\d+)\\)").findAll(input.readString())
            .sumOf { match -> match.groups[1]!!.value.toInt() * match.groups[2]!!.value.toInt() }
    }

    fun solvePart2(): Int {
        val matches = Regex("mul\\((\\d+),(\\d+)\\)|do(?:n't)?\\(\\)").findAll(input.readString())

        var enabled = true
        var result = 0

        for (match in matches) {
            when (match.value) {
                "do()" -> enabled = true
                "don't()" -> enabled = false
                else -> {
                    if (enabled) {
                        result += match.groups[1]!!.value.toInt() * match.groups[2]!!.value.toInt()
                    }
                }
            }
        }

        return result
    }
}
