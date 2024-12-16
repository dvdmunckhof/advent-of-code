package com.dvdmunckhof.aoc.common

import kotlin.math.pow

private val lengthMap = (63 downTo 0).map { n -> (1uL shl n).toString(10).length } + 1
val powerOf10 = (0..lengthMap.first()).map { 10.0.pow(it).toLong() }

val Long.base10length: Int
    get() {
        val zeroBitsCount = this.countLeadingZeroBits()
        val length = lengthMap[zeroBitsCount]
        return if (this >= powerOf10[length]) length + 1 else length
    }
