package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 14")
class Day14Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2021/day14_example.txt")
        val answer = Day14(input).solvePart1()

        Assertions.assertEquals(1_588L, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2021/day14_actual.txt")
        val answer = Day14(input).solvePart1()

        Assertions.assertEquals(2_891L, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2021/day14_example.txt")
        val answer = Day14(input).solvePart2()

        Assertions.assertEquals(2_188_189_693_529L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2021/day14_actual.txt")
        val answer = Day14(input).solvePart2()

        Assertions.assertEquals(4_607_749_009_683L, answer)
    }
}
