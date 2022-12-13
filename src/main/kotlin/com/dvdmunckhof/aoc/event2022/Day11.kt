package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.toDeque

class Day11(private val input: List<String>) {

    fun solvePart1() = solve(20, false)

    fun solvePart2() = solve(10_000, true)

    fun solve(rounds: Long, alternativeLevelManagement: Boolean): Long {
        val monkeys = input.windowed(6, 7)
            .map { lines ->
                val operationParts = lines[2].substringAfter("= ").split(" ")
                val operationValue1 = operationParts[0].toLongOrNull()
                val operationValue2 = operationParts[2].toLongOrNull()
                val operation = when (operationParts[1]) {
                    "*" -> OperationMultiply(operationValue1, operationValue2)
                    "+" -> OperationAddition(operationValue1, operationValue2)
                    else -> error("Unknown operator")
                }

                val startingItems = lines[1].substringAfter(": ").split(", ").map(String::toLong).toDeque()
                val test = lines[3].substringAfterLast(" ").toLong()
                val testTrue = lines[4].substringAfterLast(" ").toInt()
                val testFalse = lines[5].substringAfterLast(" ").toInt()
                Monkey(startingItems, operation, test, testTrue, testFalse)
            }

        val commonDenominator = monkeys.fold(1L) { acc, monkey -> acc * monkey.testDivider }

        for (round in 1..rounds) {
            for (monkey in monkeys) {
                while (monkey.items.isNotEmpty()) {
                    val currentLevel = monkey.items.removeFirst()
                    val tmpLevel = monkey.operation.apply(currentLevel)
                    val newLevel = if (alternativeLevelManagement) tmpLevel % commonDenominator else tmpLevel / 3
                    val monkeyIndex = if (newLevel % monkey.testDivider == 0L) monkey.indexTrue else monkey.indexFalse
                    monkeys[monkeyIndex].items += newLevel
                    monkey.handledItemCount++
                }
            }
        }

        return monkeys.sortedBy { it.handledItemCount }
            .takeLast(2)
            .fold(1L) { acc, monkey -> acc * monkey.handledItemCount }
    }

    private data class Monkey(
        val items: ArrayDeque<Long>,
        val operation: Operation,
        val testDivider: Long,
        val indexTrue: Int,
        val indexFalse: Int,
    ) {
        var handledItemCount: Long = 0
    }

    private sealed class Operation(private val a: Long?, private val b: Long?) {
        fun apply(old: Long): Long = apply(a ?: old, b ?: old)
        abstract fun apply(a: Long, b: Long): Long
    }

    private class OperationAddition(a: Long?, b: Long?) : Operation(a, b) {
        override fun apply(a: Long, b: Long) = a + b
    }

    private class OperationMultiply(a: Long?, b: Long?) : Operation(a, b) {
        override fun apply(a: Long, b: Long) = a * b
    }
}
