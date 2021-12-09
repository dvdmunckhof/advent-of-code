package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 09")
class Day09Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2021/day09_example.txt")
        val answer = Day09(input).solvePart1()

        Assertions.assertEquals(15, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2021/day09_actual.txt")
        val answer = Day09(input).solvePart1()

        Assertions.assertEquals(462, answer)
    }
}
