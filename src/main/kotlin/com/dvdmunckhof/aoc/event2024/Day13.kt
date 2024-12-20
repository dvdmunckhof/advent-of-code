package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput

class Day13(private val input: PuzzleInput) {

    fun solvePart1() = solve(0L)

    fun solvePart2() = solve(10000000000000L)

    private fun solve(n: Long): Long {
        val regex = Regex("Button A: X\\+(\\d+), Y\\+(\\d+)\\nButton B: X\\+(\\d+), Y\\+(\\d+)\\nPrize: X=(\\d+), Y=(\\d+)")
        return regex.findAll(input.readString()).sumOf { match ->
            val matches = match.groupValues.drop(1).map(String::toLong)
            val (buttonAX, buttonAY, buttonBX, buttonBY) = matches
            val prizeX = matches[4] + n
            val prizeY = matches[5] + n

            val pressesA = (buttonBX * prizeY - buttonBY * prizeX) / (buttonBX * buttonAY - buttonBY * buttonAX)
            val pressesB = (prizeY - pressesA * buttonAY) / buttonBY
            val resultX = pressesA * buttonAX + pressesB * buttonBX
            val resultY = pressesA * buttonAY + pressesB * buttonBY
            if (resultX == prizeX && resultY == prizeY) pressesA * 3L + pressesB else 0L
        }
    }
}
