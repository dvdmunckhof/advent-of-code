package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2024 - Day 11")
class Day11Test {

    @Test
    fun `Part 1 - Example 1`() {
        val input = PuzzleInput("files/2024/day11_example.txt")
        val answer = Day11(input, 6).solve()
        Assertions.assertEquals(22, answer)
    }

    @Test
    fun `Part 1 - Example 2`() {
        val input = PuzzleInput("files/2024/day11_example.txt")
        val answer = Day11(input, 25).solve()
        Assertions.assertEquals(55312, answer)
    }

    @Test
    fun `Part 1 - Puzzle`() {
        val input = PuzzleInput("files/2024/day11_puzzle.txt")
        val answer = Day11(input, 25).solve()
        Assertions.assertEquals(203_953, answer)
    }

    @Test
    fun `Part 2 - Puzzle`() {
        val input = PuzzleInput("files/2024/day11_puzzle.txt")
        val answer = Day11(input, 75).solve()
        Assertions.assertEquals(242_090_118_578_155, answer)
    }
}
