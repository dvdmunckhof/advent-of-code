package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import com.dvdmunckhof.aoc.common.splitAt

class Day07(input: PuzzleInput) {
    private val lines = input.readLines()

    fun solvePart1() = solve(false)

    fun solvePart2() = solve(true)

    private fun solve(concat: Boolean): Long {
        return lines.sumOf { line ->
            val (partA, partB) = line.splitAt(": ")
            val testValue = partA.toLong()
            val numbers = partB.split(" ").map(String::toLong)
            if (check(testValue, numbers, numbers[0], 1, concat)) testValue else 0L
        }
    }

    private fun check(testValue: Long, numbers: List<Long>, accumulator: Long, index: Int, concat: Boolean): Boolean {
        if (accumulator > testValue) {
            return false
        }
        if (index == numbers.size) {
            return testValue == accumulator
        }
        val value = numbers[index]
        val multiplier = when {
            value < 10 -> 10
            value < 100 -> 100
            value < 1000 -> 1000
            else -> error("Number unsupported: $value")
        }
        return check(testValue, numbers, accumulator + value, index + 1, concat)
                || check(testValue, numbers, accumulator * value, index + 1, concat)
                || concat && check(testValue, numbers, accumulator * multiplier + value, index + 1, true)
    }
}
