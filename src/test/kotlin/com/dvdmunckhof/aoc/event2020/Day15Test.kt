package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout

@DisplayName("2020 - Day 15")
@Timeout(10)
class Day15Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsIntList("2020/day15_example.txt")
        val answer = Day15(input).solvePart1()

        Assertions.assertEquals(436, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsIntList("2020/day15_actual.txt")
        val answer = Day15(input).solvePart1()

        Assertions.assertEquals(232, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsIntList("2020/day15_example.txt")
        val answer = Day15(input).solvePart2()

        Assertions.assertEquals(175594, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsIntList("2020/day15_actual.txt")
        val answer = Day15(input).solvePart2()

        Assertions.assertEquals(18929178, answer)
    }
}
