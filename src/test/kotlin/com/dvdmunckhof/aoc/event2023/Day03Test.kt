package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2023 - Day 03")
class Day03Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2023/day03_example.txt")
        val answer = Day03(input).solvePart1()

        Assertions.assertEquals(4_361, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2023/day03_actual.txt")
        val answer = Day03(input).solvePart1()

        Assertions.assertEquals(527_364, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2023/day03_example.txt")
        val answer = Day03(input).solvePart2()

        Assertions.assertEquals(467_835, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2023/day03_actual.txt")
        val answer = Day03(input).solvePart2()

        Assertions.assertEquals(79_026_871, answer)
    }
}
