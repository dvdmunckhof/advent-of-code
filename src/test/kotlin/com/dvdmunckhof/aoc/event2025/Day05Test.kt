package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2025 - Day 05")
class Day05Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2025/day05_example.txt")
        val answer = Day05(input).solvePart1()
        Assertions.assertEquals(3, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2025/day05_puzzle.txt")
        val answer = Day05(input).solvePart1()
        Assertions.assertEquals(529, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2025/day05_example.txt")
        val answer = Day05(input).solvePart2()
        Assertions.assertEquals(14L, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2025/day05_puzzle.txt")
        val answer = Day05(input).solvePart2()
        Assertions.assertEquals(344_260_049_617_193L, answer)
    }
}
