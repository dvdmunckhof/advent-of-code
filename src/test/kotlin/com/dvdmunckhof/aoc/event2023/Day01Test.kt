package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2023 - Day 01")
class Day01Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2023/day01_part1_example.txt")
        val answer = Day01(input).solvePart1()

        Assertions.assertEquals(142, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2023/day01_actual.txt")
        val answer = Day01(input).solvePart1()

        Assertions.assertEquals(54_968, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2023/day01_part2_example.txt")
        val answer = Day01(input).solvePart2()

        Assertions.assertEquals(281, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2023/day01_actual.txt")
        val answer = Day01(input).solvePart2()

        Assertions.assertEquals(54_094, answer)
    }
}
