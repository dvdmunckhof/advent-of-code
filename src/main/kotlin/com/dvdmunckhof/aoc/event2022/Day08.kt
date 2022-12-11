package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.toGrid

class Day08(input: List<List<Int>>) {
    private val grid = input.map { row -> row.map(::Tree) }.toGrid()

    fun solvePart1(): Int {
        val visibleTrees = mutableSetOf<Tree>()

        for (row in grid.rows) {
            visibleTrees += visibleTreesPart1(row)
            visibleTrees += visibleTreesPart1(row.asReversed())
        }

        for (col in grid.columns) {
            visibleTrees += visibleTreesPart1(col)
            visibleTrees += visibleTreesPart1(col.asReversed())
        }

        return visibleTrees.size
    }

    fun solvePart2(): Int {
        return grid.points().maxOf { point ->
            val height = grid[point].height
            val row = grid.rows[point.x]
            val col = grid.columns[point.y]

            val directions = listOf(
                row.subList(0, point.y).asReversed(),
                row.subList(point.y + 1, row.size),
                col.subList(0, point.x).asReversed(),
                col.subList(point.x + 1, col.size),
            )
            if (directions.any(List<Tree>::isEmpty)) {
                0
            } else {
                directions.fold(1) { scenicScore, trees ->
                    val distance = (trees.takeWhile { it.height < height }.count() + 1).coerceAtMost(trees.size)
                    scenicScore * distance
                }
            }
        }
    }

    private fun visibleTreesPart1(trees: List<Tree>): List<Tree> {
        val visibleTrees = mutableListOf(trees.first())

        for (tree in trees) {
            if (tree.height > visibleTrees.last().height) {
                visibleTrees += tree
                if (tree.height == 9) {
                    break
                }
            }
        }
        return visibleTrees
    }

    private class Tree(val height: Int)
}
