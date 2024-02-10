package com.dvdmunckhof.aoc.event2023

class Day05(input: List<String>) {
    private val seeds = input[0].split(' ').drop(1).map(String::toLong)
    private val mappings = input.drop(1).map { chunk ->
        chunk.lines()
            .drop(1)
            .map { line ->
                val values = line.split(' ').map(String::toLong)
                MappingEntry(values[1]..<values[1] + values[2], values[0])
            }
            .sortedBy { it.src.first }
    }

    fun solvePart1(): Long {
        return seeds.minOf { seed ->
            mappings.fold(seed) { n, mapping ->
                mapping.firstOrNull { entry -> n in entry.src }?.map(n) ?: n
            }
        }
    }

    fun solvePart2(): Long {
        return seeds.windowed(2, 2)
            .map { range -> range[0]..<range[0] + range[1] }
            .minOf { process(0, it) }
    }

    private fun process(mappingIndex: Int, range: LongRange): Long {
        val mapping = mappings[mappingIndex]
        val ranges = process(mapping, 0, range)
        if (mappingIndex == mappings.lastIndex) {
            return ranges.minOf { it.first }
        }

        return ranges.minOf { r -> process(mappingIndex + 1, r) }
    }

    private fun process(mapping: List<MappingEntry>, fromEntryIndex: Int, range: LongRange): Array<LongRange> {
        for (i in fromEntryIndex..mapping.lastIndex) {
            val entry = mapping[i]
            val entrySrc = entry.src

            // case 1: seed range is bigger than mapping
            if (range.first > entrySrc.last) {
                continue // skip mapping
            }

            // case 2: seed range is smaller than mapping
            if (range.last < entrySrc.first) {
                break // mappings are sorted, so no other matches will be found
            }

            // case 3: seed range is fully covered by mapping
            if (range in entrySrc) {
                return arrayOf(entry.map(range.first)..entry.map(range.last))
            }

            // case 4: seed range overlaps start of mapping
            if (range.last in entrySrc) {
                return arrayOf(
                    range.first..<entrySrc.first,
                    entry.dst..entry.map(range.last),
                )
            }

            // case 5: seed range overlaps end of mapping
            if (range.first in entrySrc) {
                return arrayOf(
                    entry.map(range.first)..entry.map(entrySrc.last),
                    *process(mapping, i + 1, entrySrc.last + 1..range.last),
                )
            }

            // case 6: middle of seed range is covered by mapping
            if (entrySrc in range) {
                return arrayOf(
                    range.first..<entrySrc.first,
                    entry.dst..entry.map(entrySrc.last),
                    *process(mapping, i + 1, entrySrc.last + 1..range.last),
                )
            }
        }

        return arrayOf(range)
    }

    private data class MappingEntry(val src: LongRange, val dst: Long) {
        fun map(n: Long): Long = dst - src.first + n
    }

    private operator fun LongRange.contains(other: LongRange): Boolean {
        return other.first in this && other.last in this
    }
}
