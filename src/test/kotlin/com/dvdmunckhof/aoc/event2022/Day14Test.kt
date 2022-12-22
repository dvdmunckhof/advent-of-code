package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 14")
class Day14Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day14_example.txt")
        val answer = Day14(input).solvePart1()

        Assertions.assertEquals(24, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day14_actual.txt")
        val answer = Day14(input).solvePart1()

        Assertions.assertEquals(638, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day14_example.txt")
        val answer = Day14(input).solvePart2()

        Assertions.assertEquals(93, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day14_actual.txt")
        val answer = Day14(input).solvePart2()

        Assertions.assertEquals(31_722, answer)
    }
}
