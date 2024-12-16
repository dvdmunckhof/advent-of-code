package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 10")
class Day10Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day10_example.txt")
        val answer = Day10(input).solvePart1()
        Assertions.assertEquals(36, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day10_puzzle.txt")
        val answer = Day10(input).solvePart1()
        Assertions.assertEquals(538, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day10_example.txt")
        val answer = Day10(input).solvePart2()
        Assertions.assertEquals(81, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day10_puzzle.txt")
        val answer = Day10(input).solvePart2()
        Assertions.assertEquals(1_110, answer)
    }
}
