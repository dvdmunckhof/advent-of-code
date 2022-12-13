package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 11")
class Day11Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day11_example.txt")
        val answer = Day11(input).solvePart1()

        Assertions.assertEquals(10605, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day11_actual.txt")
        val answer = Day11(input).solvePart1()

        Assertions.assertEquals(108240, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day11_example.txt")
        val answer = Day11(input).solvePart2()

        Assertions.assertEquals(2_713_310_158L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day11_actual.txt")
        val answer = Day11(input).solvePart2()

        Assertions.assertEquals(25_712_998_901L, answer)
    }
}
