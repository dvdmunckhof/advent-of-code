package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2023 - Day 07")
class Day07Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2023/day07_example.txt")
        val answer = Day07(input).solvePart1()

        Assertions.assertEquals(6_440, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2023/day07_actual.txt")
        val answer = Day07(input).solvePart1()

        Assertions.assertEquals(251_287_184, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2023/day07_example.txt")
        val answer = Day07(input).solvePart2()

        Assertions.assertEquals(5_905, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2023/day07_actual.txt")
        val answer = Day07(input).solvePart2()

        Assertions.assertEquals(250_757_288, answer)
    }
}
