package com.dvdmunckhof.aoc.common

fun String.splitAt(delimiter: String): Pair<String, String> {
    val index = this.indexOf(delimiter)
    if (index == -1) {
        throw IllegalStateException("Delimiter '$delimiter' not found: $this")
    }

    val first = this.substring(0, index)
    val second = this.substring(index + delimiter.length)
    return first to second
}

fun Iterable<Int>.multiply(): Int {
    return this.reduce { acc, n -> acc * n }
}

fun Iterable<Long>.multiply(): Long {
    return this.reduce { acc, n -> acc * n }
}

fun <T> Iterable<T>.groupCount(): MutableMap<T, Int> {
    val map = mutableMapOf<T, Int>()
    for (item in this) {
        map[item] = map.getOrDefault(item, 0) + 1
    }
    return map
}

fun String.toRange(delimiter: String = "-"): LongRange {
    val (a, b) = this.splitAt(delimiter)
    return a.toLong()..b.toLong()
}

val LongRange.size: Long
    get() = this.last - this.first + 1
