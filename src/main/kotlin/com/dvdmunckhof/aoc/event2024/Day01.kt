package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import kotlin.math.abs

class Day01(input: PuzzleInput) {
    val listLeft: List<Int>
    val listRight: List<Int>

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
        val map = mutableMapOf<Int, Int>()
        for (value in listRight) {
            map[value] = map.getOrDefault(value, 0) + value
        }
        return listLeft.sumOf { value -> map.getOrDefault(value, 0) }
    }
}
