package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2025 - Day 01")
class Day01Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2025/day01_example.txt")
        val answer = Day01(input).solvePart1()
        Assertions.assertEquals(3, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2025/day01_puzzle.txt")
        val answer = Day01(input).solvePart1()
        Assertions.assertEquals(1_071, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2025/day01_example.txt")
        val answer = Day01(input).solvePart2()
        Assertions.assertEquals(6, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2025/day01_puzzle.txt")
        val answer = Day01(input).solvePart2()
        Assertions.assertEquals(6_700, answer)
    }
}
