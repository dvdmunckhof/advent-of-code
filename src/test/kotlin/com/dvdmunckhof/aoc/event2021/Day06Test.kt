package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 06")
class Day06Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readSingleIntList("2021/day06_example.txt")
        val answer = Day06(input).solvePart1()

        Assertions.assertEquals(5_934, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readSingleIntList("2021/day06_actual.txt")
        val answer = Day06(input).solvePart1()

        Assertions.assertEquals(349_549, answer)
    }
}
