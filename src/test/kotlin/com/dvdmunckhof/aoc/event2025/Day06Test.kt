package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2025 - Day 06")
class Day06Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2025/day06_example.txt")
        val answer = Day06(input).solvePart1()
        Assertions.assertEquals(4_277_556L, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2025/day06_puzzle.txt")
        val answer = Day06(input).solvePart1()
        Assertions.assertEquals(3_261_038_365_331L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2025/day06_example.txt")
        val answer = Day06(input).solvePart2()
        Assertions.assertEquals(3_263_827L, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2025/day06_puzzle.txt")
        val answer = Day06(input).solvePart2()
        Assertions.assertEquals(8_342_588_849_093L, answer)
    }
}
