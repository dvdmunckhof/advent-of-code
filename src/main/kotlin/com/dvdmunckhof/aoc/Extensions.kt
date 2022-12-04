package com.dvdmunckhof.aoc

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
