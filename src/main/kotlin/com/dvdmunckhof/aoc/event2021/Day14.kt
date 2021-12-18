package com.dvdmunckhof.aoc.event2021

class Day14(private val input: List<String>) {
    private val cache = Array<MutableMap<String, Map<Char, Long>>>(41) { mutableMapOf() }
    private val rules = input.drop(2).associate { rule ->
        rule.substring(0, 2) to rule.last()
    }

    fun solvePart1(): Long = solve(10)

    fun solvePart2(): Long = solve(40)

    private fun solve(steps: Int): Long {
        val template = input.first().toMutableList()

        val count = template.windowed(2).fold(emptyMap<Char, Long>()) { count, chars ->
            val pair = chars.joinToString("")
            count(steps, pair).mergeReduce(count) { a, b -> a + b }
        }

        val min = count.minOf { it.value }
        val max = count.maxOf { it.value }
        return max - min
    }

    private fun count(step: Int, pair: String): Map<Char, Long> {
        val cachedResult = cache[step][pair]
        if (cachedResult != null) {
            return cachedResult
        }

        val rule = rules[pair]
        if (step == 0 || rule == null) {
            return pair.countChars()
        }

        val countA = count(step - 1, pair[0] + rule)
        val countB = count(step - 1, rule + pair[1])
        val result = countA.mergeReduce(countB) { a, b -> a + b }
        result[rule] = result.getValue(rule) - 1

        cache[step][pair] = result
        return result
    }

    private fun <K, V> Map<K, V>.mergeReduce(other: Map<K, V>, reduce: (V, V) -> V): MutableMap<K, V> {
        val result = this.toMutableMap()

        for (entry in other) {
            val existing = result[entry.key]
            if (existing == null) {
                result[entry.key] = entry.value
            } else {
                result[entry.key] = reduce(entry.value, existing)
            }
        }

        return result
    }

    private fun CharSequence.countChars(): Map<Char, Long> {
        val destination = mutableMapOf<Char, Long>()
        for (c in this) {
            val count = destination.getOrDefault(c, 0L)
            destination[c] = count + 1L
        }
        return destination
    }


    private operator fun Char.plus(c: Char) = this.toString() + c.toString()
}
