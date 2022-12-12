package com.dvdmunckhof.aoc.event2022

import kotlin.math.abs

class Day10(private val input: List<String>) {
    private val registerSequence = sequence {
        var registerX = 1

        for (instruction in input) {
            yield(registerX)

            if (instruction != "noop") {
                yield(registerX)
                registerX += instruction.substring(5).toInt()
            }
        }
    }

    fun solvePart1(): Int {
        return registerSequence.withIndex()
            .filter { (index, _) -> index % 40 == 19 }
            .sumOf { (index, i) -> (index + 1) * i }
    }

    fun solvePart2(): String {
        return registerSequence.windowed(40, 40)
            .joinToString("\n") { row ->
                row.withIndex().joinToString("") { (index, i) -> if (abs(index % 40 - i) <= 1) "#" else "." }
            }
    }
}
