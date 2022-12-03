package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 02")
class Day02Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day02_example.txt")
        val answer = Day02(input).solvePart1()

        Assertions.assertEquals(15, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day02_actual.txt")
        val answer = Day02(input).solvePart1()

        Assertions.assertEquals(15_572, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day02_example.txt")
        val answer = Day02(input).solvePart2()

        Assertions.assertEquals(12, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day02_actual.txt")
        val answer = Day02(input).solvePart2()

        Assertions.assertEquals(16_098, answer)
    }
}
