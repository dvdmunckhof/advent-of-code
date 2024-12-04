package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 03")
class Day03Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2024/day03_example1.txt")
        val answer = Day03(input).solvePart1()
        Assertions.assertEquals(161, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day03_puzzle.txt")
        val answer = Day03(input).solvePart1()
        Assertions.assertEquals(166_630_675, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2024/day03_example2.txt")
        val answer = Day03(input).solvePart2()
        Assertions.assertEquals(48, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day03_puzzle.txt")
        val answer = Day03(input).solvePart2()
        Assertions.assertEquals(93_465_710, answer)
    }
}
