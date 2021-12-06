package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 05")
class Day05Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2021/day05_example.txt")
        val answer = Day05(input).solvePart1()

        Assertions.assertEquals(5, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2021/day05_actual.txt")
        val answer = Day05(input).solvePart1()

        Assertions.assertEquals(4_826, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2021/day05_example.txt")
        val answer = Day05(input).solvePart2()

        Assertions.assertEquals(12, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2021/day05_actual.txt")
        val answer = Day05(input).solvePart2()

        Assertions.assertEquals(16_793, answer)
    }
}
