package com.dvdmunckhof.aoc.event2021

class Day01(private val input: List<Int>) {

    fun solvePart1(): Int {
        return input.windowed(2).count { it[0] < it [1] }
    }

    fun solvePart2(): Int {
        return input.windowed(3)
            .map { it.sum() }
            .windowed(2)
            .count { it[0] < it [1] }
    }
}
