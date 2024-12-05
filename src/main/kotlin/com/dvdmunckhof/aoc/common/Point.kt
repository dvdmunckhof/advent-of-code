package com.dvdmunckhof.aoc.common

data class Point(val r: Int, val c: Int) {

    operator fun plus(p: Point): Point {
        return Point(r + p.r, c + p.c)
    }

    operator fun minus(p: Point): Point {
        return Point(r - p.r, c - p.c)
    }

    operator fun times(value: Int): Point {
        return Point(r * value, c * value)
    }
}
