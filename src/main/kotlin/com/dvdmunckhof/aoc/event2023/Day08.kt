package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.leastCommonMultiple

class Day08(input: List<String>) {
    private val directions = input[0]
    private val nodes = input.drop(2)
        .map { line ->
            Node(line.substring(0, 3), line.substring(7, 10), line.substring(12, 15))
        }
        .associateBy { it.id }

    fun solvePart1(): Int {
        return step(0, "AAA") { it == "ZZZ" }
    }

    fun solvePart2(): Long {
        val steps = nodes.keys.filter { it.endsWith('A') }
            .map { nodeId -> step(0, nodeId) { it.endsWith('Z') }.toLong() }
        return leastCommonMultiple(steps)
    }

    private tailrec fun step(step: Int, nodeId: String, matches: (String) -> Boolean): Int {
        val node = nodes.getValue(nodeId)
        val direction = directions[step % directions.length]
        val nextNode = if (direction == 'L') node.left else node.right

        if (matches(nextNode)) {
            return step + 1
        }

        return step(step + 1, nextNode, matches)
    }

    private data class Node(val id: String, val left: String, val right: String)
}
