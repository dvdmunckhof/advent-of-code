package com.dvdmunckhof.aoc.common

class Grid<T>(collection: Collection<Collection<T>>) : Iterable<Point> {
    private val list = collection.map(Collection<T>::toMutableList).toMutableList()

    val width = list.size
    val height = list[0].size
    val size = width * height

    operator fun get(p: Point): T = list[p.x][p.y]

    operator fun set(p: Point, value: T) {
        list[p.x][p.y] = value
    }

    fun adjacent(point: Point): List<Point> = ADJACENT_OFFSETS.map { point + it }
        .filter { p -> p.x >= 0 && p.y >= 0 && p.x < width && p.y < height }

    override fun iterator(): Iterator<Point> = GridIterator()

    override fun toString(): String = list.joinToString("\n") { row -> row.joinToString("") }

    private inner class GridIterator : Iterator<Point> {
        private var index = 0
        override fun hasNext(): Boolean = index < size
        override fun next(): Point = Point(index / width, index++ % width)
    }

    companion object {
        private val ADJACENT_OFFSETS = (-1..1).flatMap { x -> (-1..1).map { y -> Point(x, y) } }.minus(Point(0, 0))
    }
}
