package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.Resources
import com.dvdmunckhof.aoc.event2021.Day18.Companion.parse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("2021 - Day 18")
class Day18Test {

    @Test
    fun `Explode - Example 1`() {
        val number = parse("[[[[[9,8],1],2],3],4]")
        number.explode()
        Assertions.assertEquals("[[[[0,9],2],3],4]", number.toString())
    }

    @Test
    fun `Explode - Example 2`() {
        val number = parse("[7,[6,[5,[4,[3,2]]]]]")
        number.explode()
        Assertions.assertEquals("[7,[6,[5,[7,0]]]]", number.toString())
    }

    @Test
    fun `Explode - Example 3`() {
        val number = parse("[[6,[5,[4,[3,2]]]],1]")
        number.explode()
        Assertions.assertEquals("[[6,[5,[7,0]]],3]", number.toString())
    }

    @Test
    fun `Explode - Example 4`() {
        val number = parse("[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]")
        number.explode()
        Assertions.assertEquals("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]", number.toString())
    }

    @Test
    fun `Explode - Example 5`() {
        val number = parse("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]")
        number.explode()
        Assertions.assertEquals("[[3,[2,[8,0]]],[9,[5,[7,0]]]]", number.toString())
    }

    @Test
    fun `Addition - Example`() {
        val number = parse("[1,1]") + parse("[2,2]") + parse("[3,3]") + parse("[4,4]")
        Assertions.assertEquals("[[[[1,1],[2,2]],[3,3]],[4,4]]", number.toString())
    }

    @Test
    fun `Reduce - Example`() {
        val number = parse("[[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]").reduce()
        Assertions.assertEquals("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]", number.toString())
    }

    @Test
    fun `Sum - Example`() {
        val input = Resources.readAsList("2021/day18_example_sum.txt")
        val answer = Day18(input).sum()

        Assertions.assertEquals("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]", answer.toString())
    }

    @Test
    fun `Part 1 - Example`() {
        val input = Resources.readAsList("2021/day18_example.txt")
        val answer = Day18(input).solvePart1()

        Assertions.assertEquals(4_140, answer)
    }

    @Test
    fun `Part 1 - Actual`() {
        val input = Resources.readAsList("2021/day18_actual.txt")
        val answer = Day18(input).solvePart1()

        Assertions.assertEquals(3_675, answer)
    }

    @Test
    fun `Part 2 - Example`() {
        val input = Resources.readAsList("2021/day18_example.txt")
        val answer = Day18(input).solvePart2()

        Assertions.assertEquals(3_993, answer)
    }

    @Test
    fun `Part 2 - Actual`() {
        val input = Resources.readAsList("2021/day18_actual.txt")
        val answer = Day18(input).solvePart2()

        Assertions.assertEquals(4_650, answer)
    }
}
