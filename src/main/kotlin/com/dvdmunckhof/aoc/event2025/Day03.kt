package com.dvdmunckhof.aoc.event2025

import com.dvdmunckhof.aoc.common.PuzzleInput

class Day03(input: PuzzleInput) {
    private val banks = input.readDigitLines()

    fun solvePart1(): Int = banks.sumOf { bank ->
        val (a, index) = bank
            .dropLast(1)
            .foldIndexed(Pair(0, 0)) { i, max, n ->
                if (max.first >= n) max else Pair(n, i)
            }
        val b = bank.drop(index + 1).max()
        a * 10 + b
    }

    fun solvePart2(): Long = banks.sumOf { bank ->
        val list = bank.toMutableList()

        outer@while (list.size > 12) {
            for (i in 0..<list.lastIndex) {
                if (list[i + 1] > list[i]) {
                    list.removeAt(i)
                    continue@outer
                }
            }
            list.removeLast()
        }

        list.fold(0L) { acc, n -> acc * 10 + n }
    }
}
