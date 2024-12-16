package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput
import com.dvdmunckhof.aoc.common.base10length
import com.dvdmunckhof.aoc.common.powerOf10

class Day11(private val input: PuzzleInput, private val blinks: Int) {
    private val cache = Array(blinks) { mutableMapOf<Long, Long>() }

    fun solve() = input.readString()
        .split(" ")
        .map(String::toLong)
        .sumOf { stone -> blink(stone, 0) }

    private fun blink(stone: Long, index: Int): Long {
        if (index == blinks) {
            return 1L
        }

        return cache[index].computeIfAbsent(stone) {
            if (stone == 0L) {
                return@computeIfAbsent blink(1L, index + 1)
            }

            val length = stone.base10length
            if (length % 2 == 0) {
                val divider = powerOf10[length / 2]
                val stoneLeft = stone / divider
                val stoneRight = stone - (stoneLeft * divider)
                blink(stoneLeft, index + 1) + blink(stoneRight, index + 1)
            } else {
                blink(stone * 2024L, index + 1)
            }
        }
    }
}
