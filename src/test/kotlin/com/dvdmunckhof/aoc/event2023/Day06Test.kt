package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2023 - Day 06")
class Day06Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2023/day06_example.txt")
        val answer = Day06(input).solvePart1()

        Assertions.assertEquals(288, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2023/day06_actual.txt")
        val answer = Day06(input).solvePart1()

        Assertions.assertEquals(2_344_708, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2023/day06_example.txt")
        val answer = Day06(input).solvePart2()

        Assertions.assertEquals(71_503, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2023/day06_actual.txt")
        val answer = Day06(input).solvePart2()

        Assertions.assertEquals(30_125_202, answer)
    }
}
