package com.dvdmunckhof.aoc.event2021

class Day05(private val input: List<String>) {

    fun solvePart1(): Int = solve(false)

    fun solvePart2(): Int = solve(true)

    private fun solve(diagonal: Boolean): Int {
        val lineRegex = Regex("""(\d+),(\d+) -> (\d+),(\d+)""")
        val map = mutableMapOf<Coordinate, Int>()

        for (line in input) {
            val values = lineRegex.find(line)!!.groupValues.drop(1).map(String::toInt)
            val from = Coordinate(values[0], values[1])
            val to = Coordinate(values[2], values[3])

            if (diagonal || from.x == to.x || from.y == to.y) {
                for (coordinate in CoordinateIterator(from, to)) {
                    map[coordinate] = map.getOrDefault(coordinate, 0) + 1
                }
            }
        }

        return map.count { it.value > 1 }
    }

    private data class Coordinate(val x: Int, val y: Int) {
        operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
    }

    private class CoordinateIterator(from: Coordinate, to: Coordinate) : Iterator<Coordinate> {
        private val step = Coordinate(to.x.compareTo(from.x), to.y.compareTo(from.y))
        private val end = to + step
        private var current = from

        override fun hasNext(): Boolean = current != end

        override fun next(): Coordinate {
            val value = current
            current = value + step
            return value
        }
    }
}
