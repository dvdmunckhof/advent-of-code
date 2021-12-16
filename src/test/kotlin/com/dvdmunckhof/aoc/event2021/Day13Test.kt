package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 13")
class Day13Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2021/day13_example.txt")
        val answer = Day13(input).solvePart1()

        Assertions.assertEquals(17, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2021/day13_actual.txt")
        val answer = Day13(input).solvePart1()

        Assertions.assertEquals(763, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2021/day13_example.txt")
        val answer = Day13(input).solvePart2()
        val expected = """
            #####
            #...#
            #...#
            #...#
            #####
            .....
            .....
        """.trimIndent()

        Assertions.assertEquals(expected, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2021/day13_actual.txt")
        val answer = Day13(input).solvePart2()
        val expected = """
            ###..#..#..##..#....###...##..###...##..
            #..#.#..#.#..#.#....#..#.#..#.#..#.#..#.
            #..#.####.#..#.#....#..#.#....#..#.#..#.
            ###..#..#.####.#....###..#....###..####.
            #.#..#..#.#..#.#....#.#..#..#.#.#..#..#.
            #..#.#..#.#..#.####.#..#..##..#..#.#..#.
        """.trimIndent()

        Assertions.assertEquals(expected, answer)
    }
}
