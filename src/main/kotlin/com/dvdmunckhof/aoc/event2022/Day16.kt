package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.common.BitSet

class Day16(private val input: List<String>) {
    private val valves = parseInput()
    private val possibleValves = valves.filter { it.flowRate != 0 }
    private val distances = calculateDistances(valves)

    fun solvePart1(): Int {
        val states = calculatePressureRelease(30)
        return states.maxOf { it.releasedPressure }
    }

    fun solvePart2(): Int {
        val states = calculatePressureRelease(26)
            .sortedByDescending { it.releasedPressure }

        return states.maxOf { state1 ->
            val state2 = states.first { state2 -> (state1.openedValves and state2.openedValves).isEmpty() }
            state1.releasedPressure + state2.releasedPressure
        }
    }

    private fun calculatePressureRelease(time: Int): List<State> {
        val states = mutableListOf<State>()

        /** Depth-first search */
        fun walkTunnels(current: Valve, openedValves: BitSet, remainingTime: Int, totalFlow: Int) {
            val releasedPressureNew = totalFlow + (remainingTime * current.flowRate)
            states += State(openedValves, releasedPressureNew)

            for (valve in possibleValves) {
                if (valve.index in openedValves) continue

                val timeRequired = distances[current.index][valve.index] + 1
                if (remainingTime < timeRequired) continue

                walkTunnels(valve, openedValves + valve.index, remainingTime - timeRequired, releasedPressureNew)
            }
        }

        val startValve = valves.first { it.name == "AA" }
        walkTunnels(startValve, BitSet(), time, 0)
        return states
    }

    private fun parseInput(): List<Valve> {
        val lineRegex = Regex("""Valve (\w+) has flow rate=(\d+); tunnels? leads? to valves? (.+)""")
        return input.mapIndexed { i, line ->
            val groups = lineRegex.matchEntire(line)!!.groupValues
            Valve(index = i, name = groups[1], flowRate = groups[2].toInt(), tunnels = groups[3].split(", "))
        }
    }

    /** Floyd–Warshall algorithm */
    private fun calculateDistances(valves: List<Valve>): List<List<Int>> {
        // initialize all distances to 100
        val dist = MutableList(valves.size) { MutableList(valves.size) { 100 } }
        val mapping = valves.associate { it.name to it.index }

        for (valve in valves) {
            // paths to itself
            dist[valve.index][valve.index] = 0
            // all tunnels
            for (tunnelName in valve.tunnels) {
                val index = mapping.getValue(tunnelName)
                dist[valve.index][index] = 1
            }
        }

        for (k in valves.indices) {
            for (i in valves.indices) {
                for (j in valves.indices) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]
                    }
                }
            }
        }

        return dist
    }

    private data class State(
        val openedValves: BitSet,
        val releasedPressure: Int,
    )

    private data class Valve(
        val index: Int,
        val name: String,
        val flowRate: Int,
        val tunnels: List<String>,
    )
}
