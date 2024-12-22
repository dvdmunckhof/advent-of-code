package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 14")
class Day14Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day14_example.txt")
        val answer = Day14(input, 11, 7).solvePart1()
        Assertions.assertEquals(12, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day14_puzzle.txt")
        val answer = Day14(input, 101, 103).solvePart1()
        Assertions.assertEquals(211_692_000, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day14_puzzle.txt")
        val answer = Day14(input, 101, 103).solvePart2()
        Assertions.assertEquals(6_587, answer)
    }
}
