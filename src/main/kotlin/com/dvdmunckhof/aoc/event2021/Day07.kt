package com.dvdmunckhof.aoc.event2021

import kotlin.math.abs
import kotlin.math.roundToInt

class Day07(private val input: List<Int>) {

    fun solvePart1(): Int {
        val position = input.sorted()[input.size / 2]
        return input.sumOf { abs(it - position) }
    }

    fun solvePart2(): Int {
        val position = input.average().roundToInt()
        return (-1..1).minOf { deviation ->
            input.sumOf {
                val distance = abs(it - position + deviation)
                distance * (distance + 1) / 2
            }
        }
    }
}

