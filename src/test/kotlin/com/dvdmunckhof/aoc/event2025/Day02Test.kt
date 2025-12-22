package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2025 - Day 02")
class Day02Test {

    @Test
    fun `Part 1 - Example`() {
        val input = PuzzleInput("files/2025/day02_example.txt")
        val answer = Day02(input).solvePart1()
        Assertions.assertEquals(1_227_775_554L, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2025/day02_puzzle.txt")
        val answer = Day02(input).solvePart1()
        Assertions.assertEquals(30_599_400_849L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = PuzzleInput("files/2025/day02_example.txt")
        val answer = Day02(input).solvePart2()
        Assertions.assertEquals(4_174_379_265L, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2025/day02_puzzle.txt")
        val answer = Day02(input).solvePart2()
        Assertions.assertEquals(46_270_373_595L, answer)
    }
}
