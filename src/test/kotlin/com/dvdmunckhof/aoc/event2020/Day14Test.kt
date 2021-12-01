package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 14")
class Day14Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2020/day14_part1_example.txt")
        val answer = Day14(input).solvePart1()

        Assertions.assertEquals(165L, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2020/day14_actual.txt")
        val answer = Day14(input).solvePart1()

        Assertions.assertEquals(14722016054794L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2020/day14_part2_example.txt")
        val answer = Day14(input).solvePart2()

        Assertions.assertEquals(208L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2020/day14_actual.txt")
        val answer = Day14(input).solvePart2()

        Assertions.assertEquals(3618217244644L, answer)
    }
}
