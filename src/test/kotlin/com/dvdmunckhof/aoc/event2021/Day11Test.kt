package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 11")
class Day11Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2021/day11_example.txt")
        val answer = Day11(input).solvePart1()

        Assertions.assertEquals(1656, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2021/day11_actual.txt")
        val answer = Day11(input).solvePart1()

        Assertions.assertEquals(1_719, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2021/day11_example.txt")
        val answer = Day11(input).solvePart2()

        Assertions.assertEquals(195, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2021/day11_actual.txt")
        val answer = Day11(input).solvePart2()

        Assertions.assertEquals(232, answer)
    }
}
