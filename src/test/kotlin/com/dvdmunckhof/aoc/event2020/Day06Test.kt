package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 06")
class Day06Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("2020/day06_example.txt")
        val answer = Day06(input).solvePart1()

        Assertions.assertEquals(11, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2020/day06_actual.txt")
        val answer = Day06(input).solvePart1()

        Assertions.assertEquals(6437, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readString("2020/day06_example.txt")
        val answer = Day06(input).solvePart2()

        Assertions.assertEquals(6, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2020/day06_actual.txt")
        val answer = Day06(input).solvePart2()

        Assertions.assertEquals(3229, answer)
    }
}
