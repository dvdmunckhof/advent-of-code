package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2022 - Day 17")
class Day17Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readString("2022/day17_example.txt")
        val shapes = Resources.readString("2022/day17_shapes.txt")
        val answer = Day17(input, shapes).solvePart1()

        Assertions.assertEquals(3_068, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readString("2022/day17_actual.txt")
        val shapes = Resources.readString("2022/day17_shapes.txt")
        val answer = Day17(input, shapes).solvePart1()

        Assertions.assertEquals(3_153, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readString("2022/day17_example.txt")
        val shapes = Resources.readString("2022/day17_shapes.txt")
        val answer = Day17(input, shapes).solvePart2()
        Assertions.assertEquals(1_514_285_714_288L, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readString("2022/day17_actual.txt")
        val shapes = Resources.readString("2022/day17_shapes.txt")
        val answer = Day17(input, shapes).solvePart2()

        Assertions.assertEquals(1_553_665_689_155L, answer)
    }
}
