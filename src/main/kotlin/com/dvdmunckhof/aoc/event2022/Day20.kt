package com.dvdmunckhof.aoc.event2022

class Day20(private val input: List<Int>) {

    fun solvePart1(): Int {
        val items = input.mapIndexed { index, value -> LinkedItem(value, index) }
        for ((a, b) in (items.asSequence() + items.first()).windowed(2)) {
            a.next = b
            b.previous = a
        }

        var first = items.first()
        first.printList()

        for (item in items) {
            if (item.value == 0) continue // TODO: remove

            val distance = if (item.value < 0) {
                (item.value - 1).mod(items.size)
            } else {
                item.value.mod(items.size)
            }
            val target = if (distance == 0) {
                item.previous.previous
            } else {
                step(item, distance)
            }

            if (item == first) {
                first = item.next
            }

            item.moveNext(target)

            print("${item.value}: ")
            first.printList()
        }

        val zero = items.first { it.value == 0 }
        return (1000..3000 step 1000).sumOf { i ->
            val target = step(zero, i.mod(items.size))
            println(target.value)
            target.value
        }
    }

    fun solvePart2(): Int {
        error("No solution found")
    }

    private tailrec fun step(item: LinkedItem, n: Int): LinkedItem {
        return if (n == 0) item else step(item.next, n - 1)
    }

    private class LinkedItem(val value: Int, val index: Int) {
        lateinit var previous: LinkedItem
        lateinit var next: LinkedItem

        override fun toString(): String {
            return value.toString()
        }

        fun moveNext(item: LinkedItem) {
            this.remove()
            this.insertAfter(item)
        }

        private fun insertAfter(item: LinkedItem) {
            this.next = item.next
            this.next.previous = this
            this.previous = item
            this.previous.next = this
        }

        private fun remove() {
            previous.next = this.next
            next.previous = this.previous
        }

        fun printList() {
            var item = this

            print("[")
            do {
                if (item != this) {
                    print(", ")
                }
                print(item.value)
                item = item.next
            } while (item != this)
            println("]")
        }
    }
}
