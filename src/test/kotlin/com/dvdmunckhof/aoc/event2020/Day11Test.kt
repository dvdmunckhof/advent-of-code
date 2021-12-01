package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 11")
class Day11Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2020/day11_example.txt")
        val answer = Day11(input).solvePart1()

        Assertions.assertEquals(37, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2020/day11_actual.txt")
        val answer = Day11(input).solvePart1()

        Assertions.assertEquals(2424, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2020/day11_example.txt")
        val answer = Day11(input).solvePart2()

        Assertions.assertEquals(26, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2020/day11_actual.txt")
        val answer = Day11(input).solvePart2()

        Assertions.assertEquals(2208, answer)
    }
}
