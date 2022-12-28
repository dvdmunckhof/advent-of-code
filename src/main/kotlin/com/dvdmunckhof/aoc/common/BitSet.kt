package com.dvdmunckhof.aoc.common

@JvmInline
value class BitSet(val value: Long = 0L) {
    operator fun contains(i: Int) = value and (1L shl i) != 0L
    operator fun plus(i: Int) = BitSet(value or (1L shl i))
    operator fun minus(i: Int) = BitSet(value and (1L shl i).inv())
}
