package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 01")
class Day01Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsIntList("2021/day01_example.txt")
        val answer = Day01(input).solvePart1()

        Assertions.assertEquals(7, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsIntList("2021/day01_actual.txt")
        val answer = Day01(input).solvePart1()

        Assertions.assertEquals(1393, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsIntList("2021/day01_example.txt")
        val answer = Day01(input).solvePart2()

        Assertions.assertEquals(5, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsIntList("2021/day01_actual.txt")
        val answer = Day01(input).solvePart2()

        Assertions.assertEquals(1359, answer)
    }
}
