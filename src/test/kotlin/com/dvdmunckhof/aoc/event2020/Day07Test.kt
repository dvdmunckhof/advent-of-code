package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 07")
class Day07Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2020/day07_example.txt")
        val answer = Day07(input).solvePart1("shiny gold")

        Assertions.assertEquals(4, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2020/day07_actual.txt")
        val answer = Day07(input).solvePart1("shiny gold")

        Assertions.assertEquals(372, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2020/day07_example.txt")
        val answer = Day07(input).solvePart2("shiny gold")

        Assertions.assertEquals(32, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2020/day07_actual.txt")
        val answer = Day07(input).solvePart2("shiny gold")

        Assertions.assertEquals(8015, answer)
    }
}
