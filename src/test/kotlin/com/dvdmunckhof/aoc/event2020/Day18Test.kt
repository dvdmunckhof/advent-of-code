package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 18")
class Day18Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2020/day18_example.txt")
        val answer = Day18(input).solvePart1()

        Assertions.assertEquals(26386L, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2020/day18_actual.txt")
        val answer = Day18(input).solvePart1()

        Assertions.assertEquals(98621258158412L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2020/day18_example.txt")
        val answer = Day18(input).solvePart2()

        Assertions.assertEquals(693942L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2020/day18_actual.txt")
        val answer = Day18(input).solvePart2()

        Assertions.assertEquals(241216538527890L, answer)
    }
}
