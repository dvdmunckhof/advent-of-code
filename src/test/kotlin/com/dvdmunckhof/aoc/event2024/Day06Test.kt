package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 06")
class Day06Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day06_example.txt")
        val answer = Day06(input).solvePart1()
        Assertions.assertEquals(41, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day06_puzzle.txt")
        val answer = Day06(input).solvePart1()
        Assertions.assertEquals(5_067, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day06_example.txt")
        val answer = Day06(input).solvePart2()
        Assertions.assertEquals(6, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day06_puzzle.txt")
        val answer = Day06(input).solvePart2()
        Assertions.assertEquals(1_793, answer)
    }
}