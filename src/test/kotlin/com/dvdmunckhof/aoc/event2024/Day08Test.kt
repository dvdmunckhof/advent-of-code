package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 08")
class Day08Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day08_example.txt")
        val answer = Day08(input).solvePart1()
        Assertions.assertEquals(14, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day08_puzzle.txt")
        val answer = Day08(input).solvePart1()
        Assertions.assertEquals(244, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day08_example.txt")
        val answer = Day08(input).solvePart2()
        Assertions.assertEquals(34, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day08_puzzle.txt")
        val answer = Day08(input).solvePart2()
        Assertions.assertEquals(912, answer)
    }
}
