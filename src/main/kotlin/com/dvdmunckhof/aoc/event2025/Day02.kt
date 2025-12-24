package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput
import com.dvdmunckhof.aoc.common.toRange

class Day02(input: PuzzleInput) {
    val ids = input.readString()
        .splitToSequence(",")
        .flatMap(String::toRange)

    fun solvePart1(): Long {
        return ids.filter {
            val id = it.toString()
            id.length % 2 == 0 && id.substring(0, id.length / 2) == id.substring(id.length / 2)
        }.sumOf { it }
    }

    fun solvePart2(): Long {
        return ids.filter {
            val id = it.toString()
            val length = id.length
            (1..length / 2).any { i -> length % i == 0 && (i..<length).all { j -> id[j] == id[j % i] } }
        }.sumOf { it }
    }
}
