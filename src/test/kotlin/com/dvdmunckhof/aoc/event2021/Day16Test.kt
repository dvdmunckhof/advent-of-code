package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 16")
class Day16Test {

    @Test
    fun `Part 1 - Example 1`() {
        val input = "8A004A801A8002F478"
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(16, answer)
    }

    @Test
    fun `Part 1 - Example 2`() {
        val input = "620080001611562C8802118E34"
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(12, answer)
    }

    @Test
    fun `Part 1 - Example 3`() {
        val input = "C0015000016115A2E0802F182340"
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(23, answer)
    }

    @Test
    fun `Part 1 - Example 4`() {
        val input = "A0016C880162017C3686B18A3D4780"
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(31, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2021/day16_actual.txt")
        val answer = Day16(input).solvePart1()

        Assertions.assertEquals(925, answer)
    }

    @Test
    fun `Part 2 - Example 1`() {
        val input = "C200B40A82"
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(3, answer)
    }

    @Test
    fun `Part 2 - Example 2`() {
        val input = "04005AC33890"
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(54, answer)
    }

    @Test
    fun `Part 2 - Example 3`() {
        val input = "880086C3E88112"
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(7, answer)
    }

    @Test
    fun `Part 2 - Example 4`() {
        val input = "CE00C43D881120"
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(9, answer)
    }

    @Test
    fun `Part 2 - Example 5`() {
        val input = "D8005AC2A8F0"
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(1, answer)
    }

    @Test
    fun `Part 2 - Example 6`() {
        val input = "F600BC2D8F"
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(0, answer)
    }

    @Test
    fun `Part 2 - Example 7`() {
        val input = "9C005AC2F8F0"
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(0, answer)
    }

    @Test
    fun `Part 2 - Example 8`() {
        val input = "9C0141080250320F1802104A08"
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(1, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2021/day16_actual.txt")
        val answer = Day16(input).solvePart2()

        Assertions.assertEquals(2_935L, answer)
    }
}
