package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 18")
class Day18Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day18_example.txt")
        val answer = Day18(input).solvePart1()

        Assertions.assertEquals(64, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day18_actual.txt")
        val answer = Day18(input).solvePart1()

        Assertions.assertEquals(3_448, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day18_example.txt")
        val answer = Day18(input).solvePart2()

        Assertions.assertEquals(58, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day18_actual.txt")
        val answer = Day18(input).solvePart2()

        Assertions.assertEquals(2_052, answer)
    }
}
