package com.dvdmunckhof.aoc.event2021

class Day10(private val input: List<String>) {

    fun solvePart1(): Int {
        val bracketPoints = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)
        return solve().filterIsInstance<LineResult.Corrupt>().sumOf { result ->
            bracketPoints.getValue(result.bracket)
        }
    }

    fun solvePart2(): Long {
        val bracketPoints = mapOf(')' to 1L, ']' to 2L, '}' to 3L, '>' to 4L)
        val scores = solve().filterIsInstance<LineResult.Incomplete>().map { result ->
            result.missingBrackets.fold(0L) { acc, c -> acc * 5L + bracketPoints.getValue(c) }
        }
        return scores.sorted()[scores.size / 2]
    }

    private fun solve(): List<LineResult> {
        val brackets = mapOf('(' to ')', '[' to ']', '{' to '}', '<' to '>')

        return input.map { line ->
            val stack = mutableListOf<Char>()
            for (c in line) {
                if (brackets.containsKey(c)) {
                    stack.add(brackets.getValue(c))
                } else if (stack.removeLast() != c) {
                    return@map LineResult.Corrupt(c)
                }
            }

            LineResult.Incomplete(stack.reversed())
        }
    }

    private sealed class LineResult {
        class Corrupt(val bracket: Char) : LineResult()
        class Incomplete(val missingBrackets: List<Char>) : LineResult()
    }
}
