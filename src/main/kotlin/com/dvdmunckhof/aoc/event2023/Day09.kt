package com.dvdmunckhof.aoc.event2023

class Day09(private val input: List<String>) {

    fun solvePart1(): Int {
        return input.map { it.split(' ').map(String::toInt).toIntArray() }
            .sumOf { process(it) }
    }

    fun solvePart2(): Int {
        error("No solution found")
    }

    private fun process(numbers: IntArray): Int {
        val next = IntArray(numbers.lastIndex) { i ->
            numbers[i + 1] - numbers[i]
        }
        if (next.all { it == 0 }) {
            return numbers[0]
        }
        return numbers.last() + process(next)
    }
}
