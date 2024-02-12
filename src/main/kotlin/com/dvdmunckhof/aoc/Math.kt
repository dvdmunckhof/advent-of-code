package com.dvdmunckhof.aoc

import kotlin.math.max
import kotlin.math.min

fun leastCommonMultiple(iterable: Iterable<Long>): Long {
    return iterable.reduce { a, b -> leastCommonMultiple(a, b) }
}

fun leastCommonMultiple(a: Long, b: Long): Long {
    if (a == 0L || b == 0L) {
        return 0L
    }

    val gcd = greatestCommonDivisor(a, b)
    return a * b / gcd
}

/**
 * Calculate the greatest common divisor using the Euclidean algorithm
 */
fun greatestCommonDivisor(a: Long, b: Long): Long {
    if (a == 0L || b == 0L) {
        return a + b
    }

    val min = min(a, b)
    val max = max(a, b)
    return greatestCommonDivisor(max % min, min)
}
