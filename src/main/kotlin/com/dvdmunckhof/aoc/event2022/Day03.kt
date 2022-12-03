package com.dvdmunckhof.aoc.event2022

class Day03(private val input: List<String>) {

    fun solvePart1(): Int {
        return input.sumOf { rucksack ->
            val compartmentA = rucksack.substring(0, rucksack.length / 2)
            val compartmentB = rucksack.substring(rucksack.length / 2)
            compartmentA.first(compartmentB::contains).priority
        }
    }

    fun solvePart2(): Int {
        return input.map(String::toHashSet)
            .windowed(3, 3)
            .sumOf { rucksacks ->
                rucksacks.reduce { a, b -> a.apply { a.retainAll(b) } }.single().priority
            }
    }

    private val Char.priority: Int
        get() = if (this.isUpperCase()) this - 'A' + 27 else this - 'a' + 1
}
