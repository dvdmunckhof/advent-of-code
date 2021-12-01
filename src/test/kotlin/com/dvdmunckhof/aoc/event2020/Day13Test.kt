package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 13")
class Day13Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2020/day13_example.txt")
        val answer = Day13(input).solvePart1()

        Assertions.assertEquals(295, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2020/day13_actual.txt")
        val answer = Day13(input).solvePart1()

        Assertions.assertEquals(3215, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2020/day13_example.txt")
        val answer = Day13(input).solvePart2()

        Assertions.assertEquals(1068781L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2020/day13_actual.txt")
        val answer = Day13(input).solvePart2()

        Assertions.assertEquals(1001569619313439L, answer)
    }
}
