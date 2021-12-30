package com.dvdmunckhof.aoc.event2021

import kotlin.math.ceil
import kotlin.math.floor

class Day18(input: List<String>) {
    private val numbers = input.map(::parse)

    fun solvePart1(): Int = sum().magnitude()

    fun solvePart2(): Int = numbers.maxOf { numberA ->
        numbers.minus(numberA).maxOf { numberB -> (numberA + numberB).magnitude() }
    }

    fun sum(): SnailFishNumber = numbers.reduce { numberA, numberB -> numberA + numberB }

    data class SnailFishNumber(private val list: MutableList<Node>) {

        @Suppress("ControlFlowWithEmptyBody")
        fun reduce(): SnailFishNumber {
            while (explode() || split());
            return this
        }

        fun explode(): Boolean {
            for (i in list.indices) {
                val nodeA = list[i]
                if (nodeA.depth <= 4) {
                    continue
                }

                if (i > 0) {
                    val nodeLeft = list[i - 1]
                    list[i - 1] = nodeLeft.copy(value = nodeLeft.value + nodeA.value)
                }

                val nodeB = list[i + 1]
                if (i + 2 < list.size) {
                    val nodeRight = list[i + 2]
                    list[i + 2] = nodeRight.copy(value = nodeRight.value + nodeB.value)
                }

                list[i] = Node(0, nodeA.depth - 1)
                list.removeAt(i + 1)

                return true
            }
            return false
        }

        fun split(): Boolean {
            for (i in list.indices) {
                val node = list[i]
                if (node.value < 10) {
                    continue
                }

                val half = node.value.toFloat() / 2
                list[i] = Node(floor(half).toInt(), node.depth + 1)
                list.add(i + 1, Node(ceil(half).toInt(), node.depth + 1))

                return true
            }
            return false
        }

        fun magnitude(): Int = MagnitudeTransformer().transform()

        operator fun plus(other: SnailFishNumber): SnailFishNumber {
            val result = ArrayList<Node>(this.list.size + other.list.size)
            this.list.mapTo(result) { node -> node.copy(depth = node.depth + 1) }
            other.list.mapTo(result) { node -> node.copy(depth = node.depth + 1) }
            return SnailFishNumber(result).reduce()
        }

        override fun toString(): String = StringTransformer().transform()

        private abstract inner class TreeTransformer<T> {
            private var index = 0

            fun transform(): T = processNode(0)

            private fun processNode(depth: Int): T {
                val node = list[index]
                return if (node.depth == depth) {
                    index++
                    transformNode(node)
                } else {
                    val valueA = processNode(depth + 1)
                    val valueB = processNode(depth + 1)
                    transformPair(valueA, valueB)
                }
            }

            abstract fun transformNode(node: Node): T
            abstract fun transformPair(valueA: T, valueB: T): T
        }

        private inner class StringTransformer : TreeTransformer<String>() {
            override fun transformNode(node: Node): String = node.value.toString()
            override fun transformPair(valueA: String, valueB: String): String = "[$valueA,$valueB]"
        }

        private inner class MagnitudeTransformer : TreeTransformer<Int>() {
            override fun transformNode(node: Node): Int = node.value
            override fun transformPair(valueA: Int, valueB: Int): Int = valueA * 3 + valueB * 2
        }
    }

    data class Node(val value: Int, val depth: Int)

    companion object {
        fun parse(line: String): SnailFishNumber {
            var depth = 0
            val result = mutableListOf<Node>()

            for (c in line) {
                when (c) {
                    '[' -> depth += 1
                    ']' -> depth -= 1
                    ',' -> {}
                    else -> result += Node(c.digitToInt(), depth)
                }
            }
            return SnailFishNumber(result)
        }
    }
}
