package com.dvdmunckhof.aoc.common

import java.io.Reader
import java.nio.file.Paths
import kotlin.io.path.reader

@JvmInline
value class PuzzleInput(private val fileName: String) {

    fun reader(): Reader {
        return Paths.get(fileName).reader()
    }

    fun readString(): String {
        return reader().use(Reader::readText).trimEnd()
    }

    fun readLines(): List<String> {
        return reader().use(Reader::readLines)
    }

    fun readDigitLines(): List<List<Int>> {
        return readLines().map { it.map(Char::digitToInt) }
    }

    fun <T> readGrid(transform: (Char) -> T): Grid<T> {
        val data = readLines().map { line -> line.map(transform) }
        return Grid(data)
    }

    fun readCharGrid(): Grid<Char> {
        val data = readLines().map(String::toList)
        return Grid(data)
    }

    fun readDigitGrid(): Grid<Int> {
        return Grid(readDigitLines())
    }
}
