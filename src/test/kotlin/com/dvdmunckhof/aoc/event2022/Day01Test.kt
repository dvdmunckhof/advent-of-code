package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 01")
class Day01Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("2022/day01_example.txt")
        val answer = Day01(input).solvePart1()

        Assertions.assertEquals(24_000, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2022/day01_actual.txt")
        val answer = Day01(input).solvePart1()

        Assertions.assertEquals(66_719, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readString("2022/day01_example.txt")
        val answer = Day01(input).solvePart2()

        Assertions.assertEquals(45_000, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2022/day01_actual.txt")
        val answer = Day01(input).solvePart2()

        Assertions.assertEquals(198_551, answer)
    }
}
