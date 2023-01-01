package com.dvdmunckhof.aoc.common

class MutableBitSet(value: Long = 0L) {
    private var delegate = BitSet(value)
    val value: Long
        get() = delegate.value

    operator fun get(i: Int) = i in delegate
    operator fun set(i: Int, v: Boolean) {
        if (v) {
            delegate += i
        } else {
            delegate -= 1
        }
    }
}
