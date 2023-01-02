package com.dvdmunckhof.aoc.common

data class Vector3d(val x: Int, val y: Int, val z: Int) {
    operator fun plus(other: Vector3d) = Vector3d(this.x + other.x, this.y + other.y, this.z + other.z)
}
