package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 02")
class Day02Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2021/day02_example.txt")
        val answer = Day02(input).solvePart1()

        Assertions.assertEquals(150, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2021/day02_actual.txt")
        val answer = Day02(input).solvePart1()

        Assertions.assertEquals(2_070_300, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2021/day02_example.txt")
        val answer = Day02(input).solvePart2()

        Assertions.assertEquals(900, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2021/day02_actual.txt")
        val answer = Day02(input).solvePart2()

        Assertions.assertEquals(2_078_985_210, answer)
    }
}
