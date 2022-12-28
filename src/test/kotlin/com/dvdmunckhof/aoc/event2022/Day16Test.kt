package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 16")
class Day16Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day16_example.txt")
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(1_651, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day16_actual.txt")
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(1_796, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day16_example.txt")
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(1_707, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day16_actual.txt")
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(1_999, answer)
    }
}
