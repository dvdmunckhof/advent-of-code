package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.splitOnce

class Day02(private val input: List<String>) {

    fun solvePart1(): Int = solve { state, direction, distance ->
        when (direction) {
            "forward" -> state.copy(position = state.position + distance)
            "up" -> state.copy(depth = state.depth - distance)
            "down" -> state.copy(depth = state.depth + distance)
            else -> error("Invalid direction")
        }
    }

    fun solvePart2(): Int = solve { state, direction, distance ->
        when (direction) {
            "forward" -> state.copy(position = state.position + distance, depth = state.depth + state.aim * distance)
            "up" -> state.copy(aim = state.aim - distance)
            "down" -> state.copy(aim = state.aim + distance)
            else -> error("Invalid direction")
        }
    }

    private fun solve(move: (state: State, direction: String, distance: Int) -> State): Int {
        val state = input.fold(State(0, 0, 0)) { state, next ->
            val (direction, distance) = next.splitOnce(" ")
            move(state, direction, distance.toInt())
        }
        return state.position * state.depth
    }

    private data class State(val position: Int, val depth: Int, val aim: Int)
}
