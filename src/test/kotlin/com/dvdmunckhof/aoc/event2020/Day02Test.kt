package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 02")
class Day02Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2020/day02_example.txt")
        val answer = Day02(input).solvePart1()

        Assertions.assertEquals(2, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2020/day02_actual.txt")
        val answer = Day02(input).solvePart1()

        Assertions.assertEquals(454, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2020/day02_example.txt")
        val answer = Day02(input).solvePart2()

        Assertions.assertEquals(1, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2020/day02_actual.txt")
        val answer = Day02(input).solvePart2()

        Assertions.assertEquals(649, answer)
    }
}
