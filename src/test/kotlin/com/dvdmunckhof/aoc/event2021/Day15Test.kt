package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 15")
class Day15Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsGrid("2021/day15_example.txt")
        val answer = Day15(input).solvePart1()

        Assertions.assertEquals(40, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsGrid("2021/day15_actual.txt")
        val answer = Day15(input).solvePart1()

        Assertions.assertEquals(602, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsGrid("2021/day15_example.txt")
        val answer = Day15(input).solvePart2()

        Assertions.assertEquals(315, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsGrid("2021/day15_actual.txt")
        val answer = Day15(input).solvePart2()

        Assertions.assertEquals(2_935, answer)
    }
}
