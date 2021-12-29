package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 17")
class Day17Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("2021/day17_example.txt")
        val answer = Day17(input).solvePart1()

        Assertions.assertEquals(45, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2021/day17_actual.txt")
        val answer = Day17(input).solvePart1()

        Assertions.assertEquals(2_278, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readString("2021/day17_example.txt")
        val answer = Day17(input).solvePart2()

        Assertions.assertEquals(112, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2021/day17_actual.txt")
        val answer = Day17(input).solvePart2()

        Assertions.assertEquals(996, answer)
    }
}
