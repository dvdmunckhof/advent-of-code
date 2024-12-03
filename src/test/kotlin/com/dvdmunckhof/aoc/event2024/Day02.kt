package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 02")
class Day02Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day02_example.txt")
        val answer = Day02(input).solvePart1()
        Assertions.assertEquals(2, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day02_puzzle.txt")
        val answer = Day02(input).solvePart1()
        Assertions.assertEquals(306, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day02_example.txt")
        val answer = Day02(input).solvePart2()
        Assertions.assertEquals(4, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day02_puzzle.txt")
        val answer = Day02(input).solvePart2()
        Assertions.assertEquals(366, answer)
    }
}
