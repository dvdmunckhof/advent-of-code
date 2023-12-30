package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2023 - Day 04")
class Day04Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2023/day04_example.txt")
        val answer = Day04(input).solvePart1()

        Assertions.assertEquals(13, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2023/day04_actual.txt")
        val answer = Day04(input).solvePart1()

        Assertions.assertEquals(21_213, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2023/day04_example.txt")
        val answer = Day04(input).solvePart2()

        Assertions.assertEquals(30, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2023/day04_actual.txt")
        val answer = Day04(input).solvePart2()

        Assertions.assertEquals(8_549_735, answer)
    }
}
