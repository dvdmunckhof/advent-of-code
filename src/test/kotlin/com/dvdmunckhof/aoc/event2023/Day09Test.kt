package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2023 - Day 09")
class Day09Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2023/day09_example.txt")
        val answer = Day09(input).solvePart1()

        Assertions.assertEquals(114, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2023/day09_actual.txt")
        val answer = Day09(input).solvePart1()

        Assertions.assertEquals(2_098_530_125, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2023/day09_example.txt")
        val answer = Day09(input).solvePart2()

        Assertions.assertEquals(2, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2023/day09_actual.txt")
        val answer = Day09(input).solvePart2()

        Assertions.assertEquals(1_016, answer)
    }
}
