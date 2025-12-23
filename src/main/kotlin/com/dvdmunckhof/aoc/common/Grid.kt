package com.dvdmunckhof.aoc.common

class Grid<T>(private val data: MutableList<MutableList<T>>): AbstractList<T>() {
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

    operator fun contains(p: Point): Boolean {
        return p.r >= 0 && p.c >= 0 && p.r < width && p.c < height
    }

    fun points(): Sequence<Point> = PointsSequence()

    fun adjacent(point: Point, diagonally: Boolean = true): List<Point> {
        val offsets = if (diagonally) DIRECTION_OFFSETS_HVD else DIRECTION_OFFSETS_HV
        return offsets.map { offset -> point + offset }.filter { it in this }
    }

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
        /** Offsets in horizontal, vertical and diagonal direction */
        val DIRECTION_OFFSETS_HVD = arrayOf(
            Point(-1, -1), // NW
            Point(-1, 0),  // N
            Point(-1, 1),  // NE
            Point(0, -1),  // W
            Point(0, 1),   // E
            Point(1, -1),  // SW
            Point(1, 0),   // S
            Point(1, 1)    // SE
        )
        val DIRECTION_OFFSETS_HV = arrayOf(
            Point(-1, 0),  // N
            Point(0, 1),   // E
            Point(1, 0),   // S
            Point(0, -1),  // W
        )
    }
}
