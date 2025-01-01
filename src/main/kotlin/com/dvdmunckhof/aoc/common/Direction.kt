package com.dvdmunckhof.aoc.common

enum class Direction(val offset: Point) {
    NORTH(Point(-1, 0)),
    EAST(Point(0, 1)),
    SOUTH(Point(1, 0)),
    WEST(Point(0, -1));

    val left by lazy { entries[(this.ordinal + 3) % 4] }
    val right by lazy { entries[(this.ordinal + 1) % 4] }
}
