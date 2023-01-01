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

    override operator fun get(index: Int): T = data[index / height][index % height]

    operator fun get(p: Point): T = data[p.r][p.c]

    operator fun set(p: Point, value: T) {
        data[p.r][p.c] = value
    }

    fun adjacent(point: Point, diagonal: Boolean = true): List<Point> {
        val offsets = if (diagonal) OFFSETS_HVD else OFFSETS_HV
        return offsets.map { point + it }
            .filter { p -> p.r >= 0 && p.c >= 0 && p.r < width && p.c < height }
    }

    fun points(): Sequence<Point> = PointsSequence()

    override fun toString(): String = columns.asReversed().joinToString("\n") { col -> col.joinToString("") }

    fun indexToPoint(index: Int): Point = Point(index / height, index % height)

    private inner class ColumnList(private val columnIndex: Int) : AbstractList<T>() {
        override val size = data.size
        override fun get(index: Int): T = data[index][columnIndex]
    }

    private inner class PointsSequence : Sequence<Point> {
        override fun iterator() = object : Iterator<Point> {
            private var index = 0
            override fun hasNext(): Boolean = index < size
            override fun next(): Point = indexToPoint(index++)
        }
    }

    companion object {
        /** Horizontal, vertical and diagonal adjacent offsets */
        private val OFFSETS_HVD = (-1..1).flatMap { r -> (-1..1).map { c -> Point(r, c) } }.minus(Point(0, 0))
        /** Horizontal and vertical adjacent offsets */
        private val OFFSETS_HV = OFFSETS_HVD.filter { it.r == 0 || it.c == 0 }
    }
}
