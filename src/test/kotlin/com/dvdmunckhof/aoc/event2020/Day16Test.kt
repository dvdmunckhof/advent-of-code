package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 16")
class Day16Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("2020/day16_example.txt")
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(71, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2020/day16_actual.txt")
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(29759, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2020/day16_actual.txt")
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(1307550234719L, answer)
    }
}
