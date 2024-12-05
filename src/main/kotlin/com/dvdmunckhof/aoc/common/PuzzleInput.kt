package com.dvdmunckhof.aoc.common

import java.io.Reader
import java.nio.file.Paths
import kotlin.io.path.reader

@JvmInline
value class PuzzleInput(val fileName: String) {

    fun reader(): Reader {
        return Paths.get(fileName).reader()
    }

    fun readString(): String {
        return reader().use(Reader::readText).trimEnd()
    }

    fun readLines(): List<String> {
        return reader().use(Reader::readLines)
    }

    fun readCharGrid(): Grid<Char> {
        val data = readLines().map(String::toList)
        return Grid(data)
    }
}
