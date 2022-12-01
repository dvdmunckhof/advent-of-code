package com.dvdmunckhof.aoc.event2022

class Day01(private val input: String) {

    fun solvePart1(): Int = solve(1)

    fun solvePart2(): Int = solve(3)

    private fun solve(n: Int): Int {
        return input.split("\n\n")
            .map { block -> block.lineSequence().sumOf(String::toInt) }
            .sorted()
            .takeLast(n)
            .sum()
    }
}
