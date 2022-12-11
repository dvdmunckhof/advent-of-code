package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 08")
class Day08Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsGrid("2022/day08_example.txt")
        val answer = Day08(input).solvePart1()

        Assertions.assertEquals(21, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsGrid("2022/day08_actual.txt")
        val answer = Day08(input).solvePart1()

        Assertions.assertEquals(1669, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsGrid("2022/day08_example.txt")
        val answer = Day08(input).solvePart2()

        Assertions.assertEquals(8, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsGrid("2022/day08_actual.txt")
        val answer = Day08(input).solvePart2()

        Assertions.assertEquals(331_344, answer)
    }
}
