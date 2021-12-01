package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import com.dvdmunckhof.aoc.event2020.Day12.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 12")
class Day12Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2020/day12_example.txt")
        val state = AbsoluteState(Direction.EAST, 0, 0)
        val answer = Day12(input).solvePart1(state)

        Assertions.assertEquals(25, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2020/day12_actual.txt")
        val state = AbsoluteState(Direction.EAST, 0, 0)
        val answer = Day12(input).solvePart1(state)

        Assertions.assertEquals(1645, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2020/day12_example.txt")
        val state = WaypointState(0, 0, 1, 10)
        val answer = Day12(input).solvePart2(state)

        Assertions.assertEquals(286, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2020/day12_actual.txt")
        val state = WaypointState(0, 0, 1, 10)
        val answer = Day12(input).solvePart2(state)

        Assertions.assertEquals(35292, answer)
    }
}
