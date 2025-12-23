package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2025 - Day 04")
class Day04Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2025/day04_example.txt")
        val answer = Day04(input).solvePart1()
        Assertions.assertEquals(13, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2025/day04_puzzle.txt")
        val answer = Day04(input).solvePart1()
        Assertions.assertEquals(1_320, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2025/day04_example.txt")
        val answer = Day04(input).solvePart2()
        Assertions.assertEquals(43, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2025/day04_puzzle.txt")
        val answer = Day04(input).solvePart2()
        Assertions.assertEquals(8_354, answer)
    }
}
