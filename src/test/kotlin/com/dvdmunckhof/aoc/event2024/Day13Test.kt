package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 13")
class Day13Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day13_example.txt")
        val answer = Day13(input).solvePart1()
        Assertions.assertEquals(480L, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day13_puzzle.txt")
        val answer = Day13(input).solvePart1()
        Assertions.assertEquals(29_388L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day13_example.txt")
        val answer = Day13(input).solvePart2()
        Assertions.assertEquals(875_318_608_908L, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day13_puzzle.txt")
        val answer = Day13(input).solvePart2()
        Assertions.assertEquals(99_548_032_866_004L, answer)
    }
}
