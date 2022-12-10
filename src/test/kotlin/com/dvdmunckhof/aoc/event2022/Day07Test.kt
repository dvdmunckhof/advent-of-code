package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 07")
class Day07Test {

    @Test
    fun `Parse file tree`() {
        val input = Resources.readAsList("2022/day07_example.txt")
        val expected = Resources.readString("2022/day07_example_tree.txt")
        val tree = Day07(input).root

        Assertions.assertEquals(expected, tree.toString("-"))
    }

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2022/day07_example.txt")
        val answer = Day07(input).solvePart1()

        Assertions.assertEquals(95437, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2022/day07_actual.txt")
        val answer = Day07(input).solvePart1()

        Assertions.assertEquals(1477771, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2022/day07_example.txt")
        val answer = Day07(input).solvePart2()

        Assertions.assertEquals(24933642, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2022/day07_actual.txt")
        val answer = Day07(input).solvePart2()

        Assertions.assertEquals(3579501, answer)
    }
}
