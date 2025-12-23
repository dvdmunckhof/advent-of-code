package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2025 - Day 03")
class Day03Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2025/day03_example.txt")
        val answer = Day03(input).solvePart1()
        Assertions.assertEquals(357, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2025/day03_puzzle.txt")
        val answer = Day03(input).solvePart1()
        Assertions.assertEquals(16_812, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2025/day03_example.txt")
        val answer = Day03(input).solvePart2()
        Assertions.assertEquals(3_121_910_778_619L, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2025/day03_puzzle.txt")
        val answer = Day03(input).solvePart2()
        Assertions.assertEquals(166_345_822_896_410L, answer)
    }
}
