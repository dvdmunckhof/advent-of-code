package com.dvdmunckhof.aoc.event2021

class Day08(private val input: List<String>) {

    fun solvePart1(): Int {
        val uniqueLengths = setOf(2, 3, 4, 7)
        return input.asSequence()
            .flatMap { it.split(" ").drop(11) }
            .count { uniqueLengths.contains(it.length) }
    }

    fun solvePart2(): Int = input.sumOf { entry ->
        val values = entry.split(" ")
        val digit1 = values.first { it.length == 2 }.toSet()
        val digit4 = values.first { it.length == 4 }.toSet()

        values.subList(11, 15).fold(0) { acc, value ->
            val digit = when (value.length) {
                2 -> 1
                3 -> 7
                4 -> 4
                5 -> when (commonChars(value, digit1, digit4)) {
                    1 to 2 -> 2
                    2 to 3 -> 3
                    1 to 3 -> 5
                    else -> error("Invalid digit")
                }
                6 -> when (commonChars(value, digit1, digit4)) {
                    2 to 3 -> 0
                    1 to 3 -> 6
                    2 to 4 -> 9
                    else -> error("Invalid digit")
                }
                7 -> 8
                else -> error("Invalid digit")
            }
            acc * 10 + digit
        }.toInt()
    }

    private fun commonChars(value: String, digit1: Set<Char>, digit4: Set<Char>): Pair<Int, Int> {
        val chars = value.toCharArray()
        val common1 = chars.count(digit1::contains)
        val common4 = chars.count(digit4::contains)
        return common1 to common4
    }
}
