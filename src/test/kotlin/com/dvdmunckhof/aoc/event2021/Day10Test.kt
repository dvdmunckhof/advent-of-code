package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 10")
class Day10Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2021/day10_example.txt")
        val answer = Day10(input).solvePart1()

        Assertions.assertEquals(26397, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2021/day10_actual.txt")
        val answer = Day10(input).solvePart1()

        Assertions.assertEquals(464_991, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2021/day10_example.txt")
        val answer = Day10(input).solvePart2()

        Assertions.assertEquals(288_957L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2021/day10_actual.txt")
        val answer = Day10(input).solvePart2()

        Assertions.assertEquals(3_662_008_566L, answer)
    }
}
