package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import com.dvdmunckhof.aoc.common.groupCount
import kotlin.math.abs

class Day01(input: PuzzleInput) {
    private val listLeft: List<Int>
    private val listRight: List<Int>

    init {
        val lines = input.readLines()
        val delimiterStart = lines[0].indexOf(' ')
        val delimiterEnd = lines[0].lastIndexOf(' ')

        listLeft = lines.map { line -> line.substring(0, delimiterStart).toInt() }
        listRight = lines.map { line -> line.substring(delimiterEnd + 1).toInt() }
    }

    fun solvePart1(): Int {
        return listLeft.sorted().zip(listRight.sorted())
            .sumOf { (a, b) -> abs(a - b) }
    }

    fun solvePart2(): Int {
        val mapRight = listRight.groupCount().mapValues { (key, count) -> count * key }
        return listLeft.sumOf { value -> mapRight.getOrDefault(value, 0) }
    }
}
