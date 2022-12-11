package com.dvdmunckhof.aoc.common

class Grid<T> private constructor(private val data: MutableList<MutableList<T>>): AbstractList<T>() {
    val width = data.size
    val height = data[0].size
    override val size = width * height

    val rows: List<List<T>> = data

    val columns: List<List<T>> = data[0].indices.map { columnIndex -> ColumnList(columnIndex) }

    constructor(collection: Iterable<Iterable<T>>)
            : this(collection.map(Iterable<T>::toMutableList).toMutableList())

    constructor(width: Int, height: Int, initialValue: T)
            : this(MutableList(width) { MutableList(height) { initialValue } })

    override operator fun get(index: Int): T = data[index / width][index % width]

    operator fun get(p: Point): T = data[p.x][p.y]

    operator fun set(p: Point, value: T) {
        data[p.x][p.y] = value
    }

    fun adjacent(point: Point, diagonal: Boolean = true): List<Point> {
        val offsets = if (diagonal) OFFSETS_HVD else OFFSETS_HV
        return offsets.map { point + it }
            .filter { p -> p.x >= 0 && p.y >= 0 && p.x < width && p.y < height }
    }

    fun points(): Sequence<Point> = PointsSequence()

    override fun toString(): String = data.joinToString("\n") { row -> row.joinToString("") }

    private inner class ColumnList(private val columnIndex: Int) : AbstractList<T>() {
        override val size = data.size
        override fun get(index: Int): T = data[index][columnIndex]
    }

    private inner class PointsSequence : Sequence<Point> {
        override fun iterator() = object : Iterator<Point> {
            private var index = 0
            override fun hasNext(): Boolean = index < size
            override fun next(): Point = Point(index / width, index++ % width)
        }
    }

    companion object {
        /** Horizontal, vertical and diagonal adjacent offsets */
        private val OFFSETS_HVD = (-1..1).flatMap { x -> (-1..1).map { y -> Point(x, y) } }.minus(Point(0, 0))
        /** Horizontal and vertical adjacent offsets */
        private val OFFSETS_HV = OFFSETS_HVD.filter { it.x == 0 || it.y == 0 }
    }
}
