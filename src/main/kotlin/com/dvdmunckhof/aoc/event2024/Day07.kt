package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import com.dvdmunckhof.aoc.common.splitAt

class Day07(input: PuzzleInput) {
    private val lines = input.readLines()

    fun solvePart1(): Long {
        return lines.sumOf { line ->
            val (partA, partB) = line.splitAt(": ")
            val testValue = partA.toLong()
            val numbers = partB.split(" ").map(String::toLong)
            if (check(testValue, numbers, numbers[0], 1)) testValue else 0L
        }
    }

    fun solvePart2(): Long {
        error("No solution")
    }

    private fun check(testValue: Long, numbers: List<Long>, accumulator: Long, index: Int): Boolean {
        if (index == numbers.size) {
             return testValue == accumulator
        }
        if (accumulator > testValue) {
             return false
        }
        return check(testValue, numbers, accumulator + numbers[index], index + 1)
                || check(testValue, numbers, accumulator * numbers[index], index + 1)
    }
}
