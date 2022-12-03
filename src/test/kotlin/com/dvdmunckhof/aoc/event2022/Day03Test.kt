package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 03")
class Day03Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day03_example.txt")
        val answer = Day03(input).solvePart1()

        Assertions.assertEquals(157, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day03_actual.txt")
        val answer = Day03(input).solvePart1()

        Assertions.assertEquals(8_153, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day03_example.txt")
        val answer = Day03(input).solvePart2()

        Assertions.assertEquals(70, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day03_actual.txt")
        val answer = Day03(input).solvePart2()

        Assertions.assertEquals(2_342, answer)
    }
}
