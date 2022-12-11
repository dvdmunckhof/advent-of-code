package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 09")
class Day09Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day09_example.txt")
        val answer = Day09(input).solvePart1()

        Assertions.assertEquals(13, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day09_actual.txt")
        val answer = Day09(input).solvePart1()

        Assertions.assertEquals(6_311, answer)
    }

    @Test
    fun `Part 2 - Example 1`() {
        val input = Resources.readAsList("2022/day09_example.txt")
        val answer = Day09(input).solvePart2()

        Assertions.assertEquals(1, answer)
    }

    @Test
    fun `Part 2 - Example 2`() {
        val input = Resources.readAsList("2022/day09_example2.txt")
        val answer = Day09(input).solvePart2()

        Assertions.assertEquals(36, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day09_actual.txt")
        val answer = Day09(input).solvePart2()

        Assertions.assertEquals(2482, answer)
    }
}
