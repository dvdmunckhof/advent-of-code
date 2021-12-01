package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 04")
class Day04Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("2020/day04_part1_example.txt")
        val answer = Day04(input).solvePart1()

        Assertions.assertEquals(2, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2020/day04_actual.txt")
        val answer = Day04(input).solvePart1()

        Assertions.assertEquals(216, answer)
    }

    @Test
    fun `Part 2 - Example - all valid`() {
        val inputValid = Resources.readString("2020/day04_part2_example_valid.txt")
        val answerValid = Day04(inputValid).solvePart2()

        Assertions.assertEquals(4, answerValid)
    }

    @Test
    fun `Part 2 - Example - all invalid`() {
        val inputInvalid = Resources.readString("2020/day04_part2_example_invalid.txt")
        val answerInvalid = Day04(inputInvalid).solvePart2()

        Assertions.assertEquals(0, answerInvalid)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2020/day04_actual.txt")
        val answer = Day04(input).solvePart2()

        Assertions.assertEquals(150, answer)
    }
}
