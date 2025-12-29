package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2025 - Day 07")
class Day07Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2025/day07_example.txt")
        val answer = Day07(input).solvePart1()
        Assertions.assertEquals(21, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2025/day07_puzzle.txt")
        val answer = Day07(input).solvePart1()
        Assertions.assertEquals(1_541, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2025/day07_example.txt")
        val answer = Day07(input).solvePart2()
        Assertions.assertEquals(40L, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2025/day07_puzzle.txt")
        val answer = Day07(input).solvePart2()
        Assertions.assertEquals(80_158_285_728_929L, answer)
    }
}
