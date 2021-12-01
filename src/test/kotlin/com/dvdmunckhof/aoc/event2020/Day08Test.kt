package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 08")
class Day08Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2020/day08_example.txt")
        val answer = Day08(input).solvePart1()

        Assertions.assertEquals(5, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2020/day08_actual.txt")
        val answer = Day08(input).solvePart1()

        Assertions.assertEquals(1521, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2020/day08_example.txt")
        val answer = Day08(input).solvePart2()

        Assertions.assertEquals(8, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2020/day08_actual.txt")
        val answer = Day08(input).solvePart2()

        Assertions.assertEquals(1016, answer)
    }
}
