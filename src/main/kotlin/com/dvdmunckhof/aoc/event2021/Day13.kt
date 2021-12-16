package com.dvdmunckhof.aoc.event2021

class Day13(private val input: List<String>) {
    private val initialPaper: List<List<Boolean>>
    private val foldInstructions: List<Pair<Char, Int>>

    init {
        val index = input.indexOf("")
        initialPaper = constructPaper(input.subList(0, index))
        foldInstructions = input.subList(index + 1, input.size).map { line ->
            val axisIndex = "fold along ".length
            line[axisIndex] to line.substring(axisIndex + 2).toInt()
        }
    }

    fun solvePart1(): Int {
        val (axis, i) = foldInstructions.first()
        val folded = fold(initialPaper, axis, i)
        return folded.sumOf { row -> row.count { it } }
    }

    fun solvePart2(): String {
        val folded = foldInstructions.fold(initialPaper) { paper, instruction ->
            val (axis, i) = instruction
            fold(paper, axis, i)
        }
        return format(folded)
    }

    private fun constructPaper(coordinates: List<String>): List<List<Boolean>> {
        val paper = mutableListOf<MutableList<Boolean>>()
        for (coordinate in coordinates) {
            val (x, y) = parseCoordinate(coordinate)
            paper.extend(y + 1) { mutableListOf() }
            val row = paper[y]
            row.extend(x + 1) { false }
            row[x] = true
        }

        val width = paper.maxOf { it.size }
        paper.forEach { row ->
            row.extend(width) { false }
        }
        return paper
    }

    private fun fold(paper: List<List<Boolean>>, axis: Char, i: Int): List<List<Boolean>> {
        return if (axis == 'x') {
            foldVertically(paper, i)
        } else {
            foldHorizontally(paper, i)
        }
    }

    private fun foldHorizontally(paper: List<List<Boolean>>, i: Int): List<List<Boolean>> {
        return fold(paper, i) { rowA, rowB ->
            rowA.zip(rowB) { a, b -> a || b }
        }
    }

    private fun foldVertically(paper: List<List<Boolean>>, i: Int): List<List<Boolean>> {
        return paper.map { row ->
            fold(row, i) { a, b -> a || b }
        }
    }

    private fun <T> fold(paper: List<T>, i: Int, zip: (T, T) -> T): List<T> {
        val partA = paper.subList(0, i)
        val partB = paper.subList(i + 1, paper.size).asReversed()

        if (partA.size > partB.size) {
            val base = partA.subList(0, partA.size - partB.size)
            val folded = partA.subList(base.size, partA.size).zip(partB, zip)
            return base + folded
        }

        if (partA.size < partB.size) {
            val base = partB.subList(partA.size, partB.size)
            val folded = partB.subList(0, partA.size).zip(partA, zip)
            return base + folded
        }

        return partA.zip(partB, zip)
    }

    private fun parseCoordinate(instruction: String): Pair<Int, Int> {
        val index = instruction.indexOf(",")
        val x = instruction.substring(0, index).toInt()
        val y = instruction.substring(index + 1).toInt()
        return x to y
    }

    private fun format(paper: List<List<Boolean>>): String {
        return paper.joinToString("\n") { row ->
            row.joinToString("") {
                if (it) "#" else "."
            }
        }
    }

    private fun <T> MutableList<T>.extend(size: Int, init: (index: Int) -> T) {
        if (this.size < size) {
            this += List(size - this.size, init)
        }
    }
}
