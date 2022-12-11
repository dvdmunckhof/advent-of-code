package com.dvdmunckhof.aoc.common

data class Point(val x: Int, val y: Int) {

    operator fun plus(p: Point): Point {
        return Point(x + p.x, y + p.y)
    }

    operator fun minus(p: Point): Point {
        return Point(x - p.x, y - p.y)
    }
}
