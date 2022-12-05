package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.rotate
import com.dvdmunckhof.aoc.splitOnce

class Day05(private val input: String) {

    fun solvePart1() = calculate(0)

    fun solvePart2() = calculate(1)

    private fun calculate(moveMultiple: Int): String {
        val parts = input.splitOnce("\n\n")
        val stacks = parts.first.lines()
            .map(String::toList)
            .rotate()
            .map { stack -> stack.takeWhile { it != ' ' }.toMutableList() }
            .filter { it.isNotEmpty() }

        val lineRegex = Regex("""move (\d+) from (\d+) to (\d+)""")
        for (line in parts.second.lines()) {
            val (count, from, to) = lineRegex.matchEntire(line)!!.groupValues.drop(1).map(String::toInt)

            val stackFrom = stacks[from - 1]
            val stackTo = stacks[to - 1]

            repeat(count) { i ->
                val item = stackFrom.removeLast()
                stackTo.add(stackTo.size - i * moveMultiple, item)
            }
        }

        return stacks.joinToString("") { it.last().toString() }
    }
}
