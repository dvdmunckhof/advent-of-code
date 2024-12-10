package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 07")
class Day07Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day07_example.txt")
        val answer = Day07(input).solvePart1()
        Assertions.assertEquals(3_749L, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day07_puzzle.txt")
        val answer = Day07(input).solvePart1()
        Assertions.assertEquals(1_620_690_235_709, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day07_example.txt")
        val answer = Day07(input).solvePart2()
        Assertions.assertEquals(11_387L, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day07_puzzle.txt")
        val answer = Day07(input).solvePart2()
        Assertions.assertEquals(145_397_611_075_341L, answer)
    }
}
