package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 19")
class Day19Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day19_example.txt")
        val answer = Day19(input).solvePart1()

        Assertions.assertEquals(33, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day19_actual.txt")
        val answer = Day19(input).solvePart1()

        Assertions.assertEquals(1_528, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day19_example.txt")
        val answer = Day19(input).solvePart2()

        Assertions.assertEquals(3_472, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day19_actual.txt")
        val answer = Day19(input).solvePart2()

        Assertions.assertEquals(16_926, answer)
    }
}
