package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2023 - Day 08")
class Day08Test {

    @Test
    fun `Part 1 - Example 1`() {
        val input = Resources.readAsList("2023/day08_example1.txt")
        val answer = Day08(input).solvePart1()

        Assertions.assertEquals(2, answer)
    }

    @Test
    fun `Part 1 - Example 2`() {
        val input = Resources.readAsList("2023/day08_example2.txt")
        val answer = Day08(input).solvePart1()

        Assertions.assertEquals(6, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2023/day08_actual.txt")
        val answer = Day08(input).solvePart1()

        Assertions.assertEquals(18_727, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2023/day08_example3.txt")
        val answer = Day08(input).solvePart2()

        Assertions.assertEquals(6, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2023/day08_actual.txt")
        val answer = Day08(input).solvePart2()

        Assertions.assertEquals(18_024_643_846_273, answer)
    }
}
