package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 04")
class Day04Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day04_example.txt")
        val answer = Day04(input).solvePart1()

        Assertions.assertEquals(2, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day04_actual.txt")
        val answer = Day04(input).solvePart1()

        Assertions.assertEquals(483, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day04_example.txt")
        val answer = Day04(input).solvePart2()

        Assertions.assertEquals(4, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day04_actual.txt")
        val answer = Day04(input).solvePart2()

        Assertions.assertEquals(874, answer)
    }
}
