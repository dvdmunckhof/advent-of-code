package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 15")
class Day15Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day15_example.txt")
        val answer = Day15(input).solvePart1(10)

        Assertions.assertEquals(26, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day15_actual.txt")
        val answer = Day15(input).solvePart1(2_000_000)

        Assertions.assertEquals(5_256_611, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day15_example.txt")
        val answer = Day15(input).solvePart2(20)

        Assertions.assertEquals(56_000_011L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day15_actual.txt")
        val answer = Day15(input).solvePart2(4_000_000)

        Assertions.assertEquals(13_337_919_186_981L, answer)
    }
}
