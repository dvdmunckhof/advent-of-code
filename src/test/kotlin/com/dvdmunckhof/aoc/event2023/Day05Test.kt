package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2023 - Day 05")
class Day05Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readChunks("2023/day05_example.txt")
        val answer = Day05(input).solvePart1()

        Assertions.assertEquals(35L, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readChunks("2023/day05_actual.txt")
        val answer = Day05(input).solvePart1()

        Assertions.assertEquals(525_792_406L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readChunks("2023/day05_example.txt")
        val answer = Day05(input).solvePart2()

        Assertions.assertEquals(46L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readChunks("2023/day05_actual.txt")
        val answer = Day05(input).solvePart2()

        Assertions.assertEquals(79_004_094L, answer)
    }
}
