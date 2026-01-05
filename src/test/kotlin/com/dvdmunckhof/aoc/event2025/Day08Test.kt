package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2025 - Day 08")
class Day08Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2025/day08_example.txt")
        val answer = Day08(input).solvePart1(10)
        Assertions.assertEquals(40, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2025/day08_puzzle.txt")
        val answer = Day08(input).solvePart1(1000)
        Assertions.assertEquals(171_503, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2025/day08_example.txt")
        val answer = Day08(input).solvePart2()
        Assertions.assertEquals(25_272L, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2025/day08_puzzle.txt")
        val answer = Day08(input).solvePart2()
        Assertions.assertEquals(9_069_509_600L, answer)
    }
}
