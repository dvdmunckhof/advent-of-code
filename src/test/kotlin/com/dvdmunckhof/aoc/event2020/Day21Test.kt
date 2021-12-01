package com.dvdmunckhof.aoc.event2020

import com.dvdmunckhof.aoc.Resources
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2020 - Day 21")
class Day21Test {

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2020/day21_example.txt")
        val answer = Day21(input).solvePart1()

        Assertions.assertEquals(5, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2020/day21_actual.txt")
        val answer = Day21(input).solvePart1()

        Assertions.assertEquals(2170, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2020/day21_example.txt")
        val answer = Day21(input).solvePart2()

        Assertions.assertEquals("mxmxvkd,sqjhc,fvjkl", answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2020/day21_actual.txt")
        val answer = Day21(input).solvePart2()

        Assertions.assertEquals("nfnfk,nbgklf,clvr,fttbhdr,qjxxpr,hdsm,sjhds,xchzh", answer)
    }
}
