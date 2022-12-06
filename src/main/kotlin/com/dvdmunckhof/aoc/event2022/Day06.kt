package com.dvdmunckhof.aoc.event2022

class Day06(private val input: String) {

    fun solvePart1() = calculate(4)

    fun solvePart2() = calculate(14)

    private fun calculate(n: Int): Int {
        return input.windowedSequence(n).indexOfFirst { it.toSet().size == it.length } + n
    }
}
