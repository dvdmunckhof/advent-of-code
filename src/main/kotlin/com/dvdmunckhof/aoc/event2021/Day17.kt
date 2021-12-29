package com.dvdmunckhof.aoc.event2021

import com.dvdmunckhof.aoc.common.Point
import com.dvdmunckhof.aoc.common.Rectangle

class Day17(input: String) {
    private val rectangle: Rectangle

    init {
        val regex = Regex("target area: x=(\\d+)\\.\\.(\\d+), y=(-\\d+)\\.\\.(-\\d+)")
        val (leftX, rightX, bottomY, topY) = regex.matchEntire(input)!!.groupValues.drop(1).map(String::toInt)
        rectangle = Rectangle(leftX, rightX, bottomY, topY)
    }

    fun solvePart1(): Int {
        val velocityY = -rectangle.bottomY - 1
        return velocityY * (velocityY + 1) / 2 // yMax = n*(n+1)/2
    }

    fun solvePart2(): Int {
        val stepsY = mutableMapOf<Int, MutableList<Int>>()
        for (vy in rectangle.bottomY..-rectangle.bottomY) {
            for (step in calculateStepsY(1, vy, 0)) {
                stepsY.getOrPut(step, ::mutableListOf) += vy
            }
        }

        val maxSteps = stepsY.keys.maxOf { it }

        val result = mutableSetOf<Point>()
        for (vx in 1..rectangle.rightX) {
            calculateStepsX(vx).takeWhile { it <= maxSteps }.forEach { step ->
                result += stepsY[step]?.map { vy -> Point(vx, vy) } ?: emptyList()
            }
        }

        return result.size
    }

    private fun calculateStepsY(step: Int, velocity: Int, position: Int): Array<Int> {
        val pos = position + velocity
        if (pos < rectangle.bottomY) {
            return emptyArray()
        }

        val results = calculateStepsY(step + 1, velocity - 1, pos)
        return if (pos <= rectangle.topY) {
            results + step
        } else {
            results
        }
    }

    private fun calculateStepsX(initialVelocity: Int) = sequence {
        var step = 1
        var position = 0
        var velocity = initialVelocity

        while (true) {
            position += velocity
            if (position > rectangle.rightX) {
                break
            }

            if (position >= rectangle.leftX) {
                yield(step)
            } else if (velocity == 0) {
                break
            }

            step++
            if (velocity > 0) {
                velocity--
            }
        }
    }
}
