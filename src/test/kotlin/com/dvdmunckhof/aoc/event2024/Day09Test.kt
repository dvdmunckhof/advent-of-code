package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 09")
class Day09Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day09_example.txt")
        val answer = Day09(input).solvePart1()
        Assertions.assertEquals(1_928L, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day09_puzzle.txt")
        val answer = Day09(input).solvePart1()
        Assertions.assertEquals(6_225_730_762_521L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day09_example.txt")
        val answer = Day09(input).solvePart2()
        Assertions.assertEquals(2_858L, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day09_puzzle.txt")
        val answer = Day09(input).solvePart2()
        Assertions.assertEquals(6_250_605_700_557L, answer)
    }
}
