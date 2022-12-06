package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 06")
class Day06Test {

    @Test
    fun `Part 1 - Example 1`() {
        val answer = Day06("mjqjpqmgbljsphdztnvjfqwrcgsmlb").solvePart1()

        Assertions.assertEquals(7, answer)
    }

    @Test
    fun `Part 1 - Example 2`() {
        val answer = Day06("bvwbjplbgvbhsrlpgdmjqwftvncz").solvePart1()

        Assertions.assertEquals(5, answer)
    }

    @Test
    fun `Part 1 - Example 3`() {
        val answer = Day06("nppdvjthqldpwncqszvftbrmjlhg").solvePart1()

        Assertions.assertEquals(6, answer)
    }

    @Test
    fun `Part 1 - Example 4`() {
        val answer = Day06("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").solvePart1()

        Assertions.assertEquals(10, answer)
    }

    @Test
    fun `Part 1 - Example 5`() {
        val answer = Day06("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").solvePart1()

        Assertions.assertEquals(11, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2022/day06_actual.txt")
        val answer = Day06(input).solvePart1()

        Assertions.assertEquals(1142, answer)
    }

    @Test
    fun `Part 2 - Example 1`() {
        val answer = Day06("mjqjpqmgbljsphdztnvjfqwrcgsmlb").solvePart2()

        Assertions.assertEquals(19, answer)
    }

    @Test
    fun `Part 2 - Example 2`() {
        val answer = Day06("bvwbjplbgvbhsrlpgdmjqwftvncz").solvePart2()

        Assertions.assertEquals(23, answer)
    }

    @Test
    fun `Part 2 - Example 3`() {
        val answer = Day06("nppdvjthqldpwncqszvftbrmjlhg").solvePart2()

        Assertions.assertEquals(23, answer)
    }

    @Test
    fun `Part 2 - Example 4`() {
        val answer = Day06("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg").solvePart2()

        Assertions.assertEquals(29, answer)
    }

    @Test
    fun `Part 2 - Example 5`() {
        val answer = Day06("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw").solvePart2()

        Assertions.assertEquals(26, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2022/day06_actual.txt")
        val answer = Day06(input).solvePart2()

        Assertions.assertEquals(2803, answer)
    }
}
