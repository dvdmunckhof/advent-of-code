package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 13")
class Day13Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day13_example.txt")
        val answer = Day13(input).solvePart1()

        Assertions.assertEquals(13, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day13_actual.txt")
        val answer = Day13(input).solvePart1()

        Assertions.assertEquals(5_808, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day13_example.txt")
        val answer = Day13(input).solvePart2()

        Assertions.assertEquals(140, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day13_actual.txt")
        val answer = Day13(input).solvePart2()

        Assertions.assertEquals(22_713, answer)
    }
}
