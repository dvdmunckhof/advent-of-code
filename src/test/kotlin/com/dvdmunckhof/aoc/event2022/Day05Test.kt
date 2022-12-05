package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 05")
class Day05Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("2022/day05_example.txt")
        val answer = Day05(input).solvePart1()

        Assertions.assertEquals("CMZ", answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2022/day05_actual.txt")
        val answer = Day05(input).solvePart1()

        Assertions.assertEquals("GFTNRBZPF", answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readString("2022/day05_example.txt")
        val answer = Day05(input).solvePart2()

        Assertions.assertEquals("MCD", answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2022/day05_actual.txt")
        val answer = Day05(input).solvePart2()

        Assertions.assertEquals("VRQWPDSGP", answer)
    }
}
