package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 20")
class Day20Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsIntList("2022/day20_example.txt")
        val answer = Day20(input).solvePart1()

        Assertions.assertEquals(3, answer)
    }

//    @Test
//    fun `Part 1 - Actual`() {
//        val input = Resources.readAsList("2022/day20_actual.txt")
//        val answer = Day20(input).solvePart1()
//
//        Assertions.assertEquals(0, answer)
//    }

//    @Test
//    fun `Part 2 - Example`() {
//        val input = Resources.readAsList("2022/day20_example.txt")
//        val answer = Day20(input).solvePart2()
//
//        Assertions.assertEquals(0, answer)
//    }

//    @Test
//    fun `Part 2 - Actual`() {
//        val input = Resources.readAsList("2022/day20_actual.txt")
//        val answer = Day20(input).solvePart2()
//
//        Assertions.assertEquals(0, answer)
//    }
}
