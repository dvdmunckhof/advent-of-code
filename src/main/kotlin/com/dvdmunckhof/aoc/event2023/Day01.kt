package com.dvdmunckhof.aoc.event2023

class Day01(private val input: List<String>) {

    fun solvePart1(): Int {
        return input.sumOf { line ->
            line.first(Char::isDigit).digitToInt() * 10 + line.last(Char::isDigit).digitToInt()
        }
    }

    fun solvePart2(): Int {
        val digits = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        val digitsMap = digits.mapIndexed { i, word -> word to i + 1 }.toMap() + (1..9).associateBy { i -> i.toString() }

        val patternStart = Regex(digits.joinToString("|", "(\\d|", ")"))
        val patternEnd = Regex(digits.joinToString("|", ".*(\\d|", ")"))

        return input.sumOf { line ->
            val digit1 = digitsMap.getValue(patternStart.find(line)!!.groupValues[1])
            val digit2 = digitsMap.getValue(patternEnd.find(line)!!.groupValues[1])
            digit1 * 10 + digit2
        }
    }
}
