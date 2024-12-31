package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 16")
class Day16Test {

    @Test
    fun `Part 1 - Example 1`() {
        val input = PuzzleInput("files/2024/day16_example1.txt")
        val answer = Day16(input).solvePart1()
        Assertions.assertEquals(7_036, answer)
    }

    @Test
    fun `Part 1 - Example 2`() {
        val input = PuzzleInput("files/2024/day16_example2.txt")
        val answer = Day16(input).solvePart1()
        Assertions.assertEquals(11_048, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day16_puzzle.txt")
        val answer = Day16(input).solvePart1()
        Assertions.assertEquals(0, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day16_example.txt")
        val answer = Day16(input).solvePart2()
        Assertions.assertEquals(0, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day16_puzzle.txt")
        val answer = Day16(input).solvePart2()
        Assertions.assertEquals(0, answer)
    }
}
