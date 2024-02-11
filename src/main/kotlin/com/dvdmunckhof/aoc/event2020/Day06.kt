package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.groupCount

class Day06(private val input: String) {

    fun solvePart1(): Int {
        return input.split("\n\n").sumOf { it.replace("\n", "").toSet().size }
    }

    fun solvePart2(): Int {
        return input.trim().split("\n\n").sumOf { group ->
            val groupSize = group.count { it == '\n' } + 1
            group.replace("\n", "").groupCount().count { it.value == groupSize }
        }
    }
}
