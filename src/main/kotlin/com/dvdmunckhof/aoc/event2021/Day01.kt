package com.dvdmunckhof.aoc.event2021

class Day01(private val input: List<Int>) {

    fun solvePart1(): Int = solve(2)

    fun solvePart2(): Int = solve(4)

    private fun solve(step: Int): Int {
        return input.windowed(step).count { it.first() < it.last() }
    }
}
