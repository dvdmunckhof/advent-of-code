package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput

class Day02(val input: PuzzleInput) {

    fun solvePart1(): Int {
        return input.readLines().count { line ->
            val numbers = line.split(" ").map(String::toInt)
            val range = if (numbers[0] < numbers[1]) 1..3 else -3..-1
            numbers.zipWithNext { a, b -> b - a }.all { i -> i in range }
        }
    }

    fun solvePart2(): Int {
        return input.readLines().count { line ->
            val numbers = line.split(" ").map(String::toInt)
            numbers.indices.any { i -> verifyReport(numbers, 1..3, i) || verifyReport(numbers, -3..-1, i) }
        }
    }

    private fun verifyReport(numbers: List<Int>, range: IntRange, skipIndex: Int): Boolean {
        var i = if (skipIndex == 0) 1 else 0
        var j = if (skipIndex == 0 || skipIndex == 1) 2 else 1

        do {
            if (numbers[j] - numbers[i] !in range) {
                return false
            }

            i = j
            j++
            if (j == skipIndex) {
                j++
            }
        } while (j < numbers.size)
        return true
    }
}
