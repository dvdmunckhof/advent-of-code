package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 19")
class Day19Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("2020/day19_part1_example.txt")
        val answer = Day19(input).solvePart1()

        Assertions.assertEquals(2, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2020/day19_actual.txt")
        val answer = Day19(input).solvePart1()

        Assertions.assertEquals(213, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readString("2020/day19_part2_example.txt")
        val answer = Day19(input).solvePart2()

        Assertions.assertEquals(12, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2020/day19_actual.txt")
        val answer = Day19(input).solvePart2()

        Assertions.assertEquals(325, answer)
    }
}
