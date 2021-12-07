package com.dvdmunckhof.aoc.event2021

class Day06(private val input: List<Int>) {

    fun solvePart1(): Long = solve(80)

    fun solvePart2(): Long = solve(256)

    private fun solve(days: Int): Long {
        val count = calculate(days)
        return input.sumOf { n -> count[n] }
    }

    private fun calculate(days: Int): LongArray {
        if (days == 0) {
            return LongArray(9) { 1L }
        }

        val count = calculate(days - 1)
        return LongArray(9) { i ->
            if (i == 0) {
                count[6] + count[8]
            } else {
                count[i - 1]
            }
        }
    }
}
