package com.dvdmunckhof.aoc.event2022

class Day02(private val input: List<String>) {

    fun solvePart1(): Int {
        return input.sumOf {
            val a = it[0] - 'A'
            val b = it[2] - 'X'

            val result = when (a) {
                b -> 3
                (b + 2) % 3 -> 6
                else -> 0
            }
            result + b + 1
        }
    }

    fun solvePart2(): Int {
        return input.sumOf {
            val a = it[0] - 'A'
            val result = (it[2] - 'X') * 3

            val b = when (result) {
                0 -> (a + 2) % 3
                3 -> a
                6 -> (a + 1) % 3
                else -> error("Impossible")
            }

            result + b + 1
        }
    }
}
