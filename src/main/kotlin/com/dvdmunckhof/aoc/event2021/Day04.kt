package com.dvdmunckhof.aoc.event2021

class Day04(private val input: String) {

    fun solvePart1(): Int = solve(true)

    fun solvePart2(): Int = solve(false)

    private fun solve(firstMatch: Boolean): Int {
        val parts = input.split("\n\n")
        val numbers = parts.first().split(",").map(String::toInt)

        val spaceRegex = Regex("\\s+")
        val cards = parts.drop(1).map {
            val rows = it.split("\n").map { row ->
                row.trim().split(spaceRegex).map(String::toInt)
            }
            Card(rows)
        }.toMutableList()

        for (n in numbers) {
            val cardIterator = cards.listIterator()
            for (card in cardIterator) {
                if (card.checkBingo(n)) {
                    cardIterator.remove()
                    if (firstMatch || cards.isEmpty()) {
                        return n * card.remainingNumbers.sum()
                    }
                }
            }
        }

        error("No solution found")
    }

    private class Card(rows: List<List<Int>>) {
        private val numbers = mutableMapOf<Int, Pair<Int, Int>>()
        private val rows = rows.map(List<Int?>::toMutableList).toMutableList()
        private val columns = MutableList<MutableList<Int?>>(rows.first().size) { i ->
            rows.map { row -> row[i] }.toMutableList()
        }
        val remainingNumbers: Set<Int>
            get() = numbers.keys

        init {
            rows.forEachIndexed { x, row ->
                row.forEachIndexed { y, n ->
                    numbers[n] = x to y
                }
            }
        }

        fun checkBingo(n: Int): Boolean {
            val (x, y) = numbers.remove(n) ?: return false

            val row = rows[x]
            row[y] = null

            val col = columns[y]
            col[x] = null

            return row.all { it == null } || col.all { it == null }
        }
    }
}

