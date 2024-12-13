package com.dvdmunckhof.aoc.event2024

import com.dvdmunckhof.aoc.common.PuzzleInput

class Day09(private val input: PuzzleInput) {

    fun solvePart1(): Long {
        val list = input.readString().map(Char::digitToInt).toMutableList()

        var index = 0
        var position = 0
        var checksum = 0L

        while (index < list.size) {
            if (index % 2 == 0) {
                val fileIndex = index / 2
                repeat(list[index]) {
                    checksum += position++ * fileIndex
                }
                index++
                continue
            }

            var freeBlocks = list[index]
            val fileIndex = list.size / 2
            var lastFileBlocks = list.removeLast()

            while (freeBlocks > 0 && lastFileBlocks > 0) {
                checksum += position++ * fileIndex
                freeBlocks--
                lastFileBlocks--
            }

            if (freeBlocks == 0) {
                index++
            } else {
                list[index] = freeBlocks
            }

            if (lastFileBlocks == 0) {
                list.removeLast() // remove free blocks
            } else {
                list += lastFileBlocks // re-add remaining blocks
            }
        }
        return checksum
    }

    fun solvePart2(): Long {
        val list = input.readString().map(Char::digitToInt)
            .mapIndexed { index, n -> if (index % 2 == 0) Space.File(index / 2, n) else Space.Free(n) }
            .toMutableList()

        var srcIndex = list.lastIndex
        var maxSize = Int.MAX_VALUE

        outer@while (srcIndex > 0) {
            val src = list[srcIndex]
            if (src is Space.Free || src.size >= maxSize) {
                srcIndex--
                continue
            }

            for (dstIndex in 0..<srcIndex) {
                val dst = list[dstIndex]
                if (dst is Space.Free && dst.size >= src.size) {
                    list[dstIndex] = src
                    list[srcIndex] = Space.Free(src.size)
                    if (dst.size > src.size) {
                        list.add(dstIndex + 1, Space.Free(dst.size - src.size))
                    } else {
                        srcIndex--
                    }
                    continue@outer
                }
            }

            srcIndex--
            maxSize = src.size
        }

        return checksum(list)
    }

    private fun checksum(list: List<Space>): Long {
        var index = 0
        var checksum = 0L

        for (item in list) {
            if (item is Space.File) {
                for (i in 0..<item.size) {
                    checksum += (index + i) * item.id
                }
            }
            index += item.size
        }

        return checksum
    }

    sealed class Space {
        abstract val size: Int

        data class File(val id: Int, override val size: Int) : Space()
        data class Free(override val size: Int) : Space()
    }
}
