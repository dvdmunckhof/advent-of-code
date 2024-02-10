package com.dvdmunckhof.aoc.event2023

import com.dvdmunckhof.aoc.multiply
import kotlin.math.pow
import kotlin.math.sqrt

class Day06(private val input: List<String>) {

    fun solvePart1(): Int {
        val (times, distances) = input.map { line -> line.split(' ').mapNotNull(String::toIntOrNull) }
        val wins = times.zip(distances).map { (time, distance) ->
            (1..<time).count { t -> t * (time - t) > distance }
        }
        return wins.filter { it > 0 }.multiply()
    }

    fun solvePart2(): Long {
        val (time, distance) = input.map { line -> line.filter(Char::isDigit).toLong() }
        val (a, b) = solveQuadraticEquation(-1.0, time.toDouble(), -distance.toDouble())
        return b.toLong() - a.toLong()
    }

    private fun solveQuadraticEquation(a: Double, b: Double, c: Double): Pair<Double, Double> {
        val discriminant = b.pow(2) - (4 * a * c)
        val root1 = (-b + sqrt(discriminant)) / (2 * a)
        val root2 = (-b - sqrt(discriminant)) / (2 * a)
        return root1 to root2
    }
}
