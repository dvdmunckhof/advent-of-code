package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 04")
class Day04Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("2021/day04_example.txt")
        val answer = Day04(input).solvePart1()

        Assertions.assertEquals(4_512, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2021/day04_actual.txt")
        val answer = Day04(input).solvePart1()

        Assertions.assertEquals(38_594, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readString("2021/day04_example.txt")
        val answer = Day04(input).solvePart2()

        Assertions.assertEquals(1_924, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2021/day04_actual.txt")
        val answer = Day04(input).solvePart2()

        Assertions.assertEquals(21_184, answer)
    }
}
