package com.dvdmunckhof.aoc.event2022

import com.dvdmunckhof.aoc.splitOnce

class Day07(private val input: List<String>) {
    val root = parseTerminalOutput()

    fun solvePart1(): Int {
        val results = filterTree(root) { it.size < 100_000 }
        return results.sumOf { it.size }
    }

    fun solvePart2(): Int {
        val requiredSpace = root.size - 40_000_000
        val results = filterTree(root) { it.size > requiredSpace }
        return results.minOf { it.size }
    }

    private fun filterTree(dir: Dir, predicate: (node: Node) -> Boolean): List<Node> {
        val results = dir.children.filterIsInstance<Dir>()
            .flatMap { filterTree(it, predicate) }

        return if (predicate(dir)) results + dir else results
    }

    private fun parseTerminalOutput(): Dir {
        val root = Dir("/", null)
        var cwd: Dir = root

        for (line in input) {
            if (line.startsWith("$ cd")) {
                val dir = line.substringAfterLast(" ")
                cwd = when (dir) {
                    "/" -> root
                    ".." -> cwd.parent!!
                    else -> cwd.subDir(dir)
                }
            } else if (line != "$ ls") {
                if (line.startsWith("dir")) {
                    val name = line.substring(4)
                    cwd.children += Dir(name, cwd)
                } else {
                    val (size, name) = line.splitOnce(" ")
                    cwd.children += File(name, size.toInt(), cwd)
                }
            }
        }

        return root
    }

    sealed class Node(val name: String, val parent: Dir?) {
        abstract val size: Int
        abstract fun toString(prefix: String): String
    }

    class File(name: String, override val size: Int, parent: Dir?) : Node(name, parent) {
        override fun toString(prefix: String) = "$prefix $name (file, size=$size)"
    }
    class Dir(name: String, parent: Dir?) : Node(name, parent) {
        val children = mutableListOf<Node>()

        fun subDir(name: String): Dir {
            return children.first { it.name == name } as Dir
        }

        override val size by lazy {
            children.sumOf(Node::size)
        }

        override fun toString(prefix: String): String {
            return children.joinToString("\n", "$prefix $name (dir)\n") { it.toString("  $prefix") }
        }
    }
}
