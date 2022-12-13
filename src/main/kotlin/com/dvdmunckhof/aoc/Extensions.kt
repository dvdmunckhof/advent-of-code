package com.dvdmunckhof.aoc

import com.dvdmunckhof.aoc.common.Grid

fun String.splitOnce(delimiter: String): Pair<String, String> {
    val index = this.indexOf(delimiter)
    if (index == -1) {
        throw IllegalStateException("Delimiter '$delimiter' not found: $this")
    }

    val first = this.substring(0, index)
    val second = this.substring(index + delimiter.length)
    return first to second
}

fun String.toRange(): IntRange {
    val (start, end) = this.splitOnce("-")
    return start.toInt()..end.toInt()
}

fun <T> List<T>.toDeque(): ArrayDeque<T> = ArrayDeque(this)

fun <T> List<List<T>>.rotate(): List<List<T>> {
    return (0..this[0].lastIndex).map { row -> (0..lastIndex).map { col -> this[lastIndex - col][row] } }
}

fun <T> Iterable<Iterable<T>>.toGrid(): Grid<T> = Grid(this)
