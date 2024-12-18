package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 12")
class Day12Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day12_example.txt")
        val answer = Day12(input).solvePart1()
        Assertions.assertEquals(1_930, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day12_puzzle.txt")
        val answer = Day12(input).solvePart1()
        Assertions.assertEquals(1_456_082, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day12_example.txt")
        val answer = Day12(input).solvePart2()
        Assertions.assertEquals(1_206, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day12_puzzle.txt")
        val answer = Day12(input).solvePart2()
        Assertions.assertEquals(872_382, answer)
    }
}
