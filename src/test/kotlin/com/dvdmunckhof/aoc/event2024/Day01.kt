package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 01")
class Day01Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day01_example.txt")
        val answer = Day01(input).solvePart1()
        Assertions.assertEquals(11, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day01_puzzle.txt")
        val answer = Day01(input).solvePart1()
        Assertions.assertEquals(2_285_373, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day01_example.txt")
        val answer = Day01(input).solvePart2()
        Assertions.assertEquals(31, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day01_puzzle.txt")
        val answer = Day01(input).solvePart2()
        Assertions.assertEquals(21_142_653, answer)
    }
}
