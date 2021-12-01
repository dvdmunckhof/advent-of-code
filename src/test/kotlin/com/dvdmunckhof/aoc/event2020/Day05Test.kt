package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 05")
class Day05Test {

    @Test
    fun `Sead IDs`() {
        val input = Resources.readAsList("2020/day05_example.txt")
        val seatIds = input.map(Day05::getSeatId)

        Assertions.assertIterableEquals(listOf(567, 119, 820), seatIds)
    }

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2020/day05_example.txt")
        val answer = Day05(input).solvePart1()

        Assertions.assertEquals(820, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2020/day05_actual.txt")
        val answer = Day05(input).solvePart1()

        Assertions.assertEquals(801, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2020/day05_actual.txt")
        val answer = Day05(input).solvePart2()

        Assertions.assertEquals(597, answer)
    }
}
