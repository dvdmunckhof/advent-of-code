package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 04")
class Day04Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day04_example.txt")
        val answer = Day04(input).solvePart1()
        Assertions.assertEquals(18, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day04_puzzle.txt")
        val answer = Day04(input).solvePart1()
        Assertions.assertEquals(2_507, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day04_example.txt")
        val answer = Day04(input).solvePart2()
        Assertions.assertEquals(9, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day04_puzzle.txt")
        val answer = Day04(input).solvePart2()
        Assertions.assertEquals(1_969, answer)
    }
}
