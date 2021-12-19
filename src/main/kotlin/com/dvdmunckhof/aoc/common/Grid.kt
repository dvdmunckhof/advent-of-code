package com.dvdmunckhof.aoc.common

class Grid<T> private constructor(private val list: MutableList<MutableList<T>>): Iterable<Point> {
    val width = list.size
    val height = list[0].size
    val size = width * height

    val data: List<List<T>>
        get() = list

    constructor(collection: Collection<Collection<T>>)
            : this(collection.map(Collection<T>::toMutableList).toMutableList())

    constructor(width: Int, height: Int, initialValue: T)
            : this(MutableList(width) { MutableList(height) { initialValue } })

    operator fun get(p: Point): T = list[p.x][p.y]

    operator fun set(p: Point, value: T) {
        list[p.x][p.y] = value
    }

    fun adjacent(point: Point, diagonal: Boolean = true): List<Point> {
        val offsets = if (diagonal) OFFSETS_HVD else OFFSETS_HV
        return offsets.map { point + it }
            .filter { p -> p.x >= 0 && p.y >= 0 && p.x < width && p.y < height }
    }

    override fun iterator(): Iterator<Point> = GridIterator()

    override fun toString(): String = list.joinToString("\n") { row -> row.joinToString("") }

    private inner class GridIterator : Iterator<Point> {
        private var index = 0
        override fun hasNext(): Boolean = index < size
        override fun next(): Point = Point(index / width, index++ % width)
    }

    companion object {
        /** Horizontal, vertical and diagonal adjacent offsets */
        private val OFFSETS_HVD = (-1..1).flatMap { x -> (-1..1).map { y -> Point(x, y) } }.minus(Point(0, 0))
        /** Horizontal and vertical adjacent offsets */
        private val OFFSETS_HV = OFFSETS_HVD.filter { it.x == 0 || it.y == 0 }
    }
}
