package com.dvdmunckhof.aoc.event2022

import java.util.ArrayDeque as Deque

class Day13(private val input: List<String>) {

    fun solvePart1(): Int {
        return input.asSequence()
            .filter { it.isNotEmpty() }
            .map { line -> parseArray(Deque(line.toList())) }
            .windowed(2, 2)
            .mapIndexed { index, list -> index + 1 to list }
            .filter { (_, list) -> list[0] < list[1] }
            .sumOf { (index, _) -> index }
    }

    fun solvePart2(): Int {
        val divider1 = PacketList(PacketList(PacketInteger(2)))
        val divider2 = PacketList(PacketList(PacketInteger(6)))
        val sorted = input.asSequence()
            .filter { it.isNotEmpty() }
            .map { line -> parseArray(Deque(line.toList())) }
            .plus(divider1)
            .plus(divider2)
            .sorted()
        return (sorted.indexOf(divider1) + 1) * (sorted.indexOf(divider2) + 1)
    }

    private fun parseArray(deque: Deque<Char>): PacketList {
        deque.removeFirst()
        val result = mutableListOf<PacketValue>()
        while (true) {
            if (deque.peekFirst() == '[') {
                result.add(parseArray(deque))
            }

            when (val c = deque.removeFirst()) {
                ']' -> break
                ',' -> {}
                else -> {
                    val value = if (deque.peekFirst().isDigit()) {
                        c.digitToInt() * 10 + deque.removeFirst().digitToInt()
                    } else {
                        c.digitToInt()
                    }
                    result += PacketInteger(value)
                }
            }
        }
        return PacketList(result)
    }

    private sealed interface PacketValue : Comparable<PacketValue>

    private class PacketList(val items: List<PacketValue>) : PacketValue, Comparable<PacketValue> {
        constructor(item: PacketValue) : this(listOf(item))

        override fun compareTo(other: PacketValue): Int {
            if (other !is PacketList) {
                return this.compareTo(PacketList(other))
            }

            for (i in this.items.indices) {
                if (i >= other.items.size) {
                    return 1
                }

                val a = this.items[i]
                val b = other.items[i]
                val result = a.compareTo(b)
                if (result != 0) {
                    return result
                }
            }
            return if (this.items.size < other.items.size) {
                -1
            } else {
                0
            }
        }

        override fun toString(): String = items.joinToString(",", "[", "]")
    }

    private class PacketInteger(val value: Int) : PacketValue {
        override fun compareTo(other: PacketValue): Int {
            return if (other is PacketInteger) {
                this.value.compareTo(other.value)
            } else {
                -other.compareTo(PacketList(this))
            }
        }

        override fun toString(): String = value.toString()
    }
}
