package com.dvdmunckhof.aoc.event2021

class Day06(private val input: List<Int>) {

    fun solvePart1(): Int = solve(80)

    fun solvePart2(): Int = solve(256)

    private fun solve(days: Int): Int {
        val state = input.toMutableList()

        for (day in 1..days) {
            for (i in state.indices) {
                val current = state[i]
                if (current == 0) {
                    state[i] = 6
                    state += 8
                } else {
                    state[i] = current - 1
                }
            }
        }

        return state.size
    }
}
