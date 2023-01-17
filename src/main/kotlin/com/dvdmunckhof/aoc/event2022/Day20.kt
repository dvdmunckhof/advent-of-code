package com.dvdmunckhof.aoc.event2022

class Day20(private val input: List<Int>) {

    fun solvePart1(): Int {
        val items = input.map { LinkedItem(it) }
        for ((a, b) in (items.asSequence() + items.first()).windowed(2)) {
            a.next = b
            b.previous = a
        }

//        val first = items.first()
//        var item = first
//
//        do {
//            println(item.value)
//            item = item.next
//        } while (item != first)
        items.print()

        for (item in items) {
            if (item.value == 0) continue

            val distance = item.value.mod(items.size)
            val targetP = step(item, distance)
            val targetN = targetP.next
            val currentP = item.previous
            val currentN = item.next

            targetP.next = item
            targetN.previous = item

            item.previous = targetP
            item.next = targetN

            currentP.next = currentN
            currentN.previous = currentP

            items.print()
        }

        error("No solution found")
    }

    fun solvePart2(): Int {
        error("No solution found")
    }

    private tailrec fun step(item: LinkedItem, n: Int): LinkedItem {
        return if (n == 0) item else step(item.next, n - 1)
    }

    private fun List<LinkedItem>.print() {
        val first = this.first()
        var item = first

        print("[")
        do {
            if (item != first) {
                print(", ")
            }
            print(item.value)
            item = item.next
        } while (item != first)
        println("]")
    }

    private data class LinkedItem(val value: Int) {
        lateinit var previous: LinkedItem
        lateinit var next: LinkedItem

        override fun toString(): String {
            return value.toString()
        }
    }
}
