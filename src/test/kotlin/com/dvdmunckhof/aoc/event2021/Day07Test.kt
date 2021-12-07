package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 07")
class Day07Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readSingleIntList("2021/day07_example.txt")
        val answer = Day07(input).solvePart1()

        Assertions.assertEquals(37, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readSingleIntList("2021/day07_actual.txt")
        val answer = Day07(input).solvePart1()

        Assertions.assertEquals(340_052, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readSingleIntList("2021/day07_example.txt")
        val answer = Day07(input).solvePart2()

        Assertions.assertEquals(168, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readSingleIntList("2021/day07_actual.txt")
        val answer = Day07(input).solvePart2()

        Assertions.assertEquals(92_948_968, answer)
    }
}
