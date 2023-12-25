package com.dvdmunckhof.aoc

import java.io.Reader

object Resources {

    fun readString(fileName: String): String {
        return resourceReader(fileName).readText().trimEnd()
    }

    fun readAsList(fileName: String): List<String> {
        return resourceReader(fileName).readLines()
    }

    fun readAsIntList(fileName: String): List<Int> {
        return readAsList(fileName).map(String::toInt)
    }

    fun readAsLongList(fileName: String): List<Long> {
        return readAsList(fileName).map(String::toLong)
    }

    fun readSingleIntList(fileName: String): List<Int> {
        return readString(fileName).split(",").map(String::toInt)
    }

    fun readAsGrid(fileName: String): List<List<Int>> {
        return readAsList(fileName).map { row -> row.map(Char::digitToInt) }
    }

    private fun resourceReader(fileName: String): Reader {
        return javaClass.classLoader.getResourceAsStream(fileName)?.reader()
            ?: throw IllegalArgumentException("Cannot find Resource: $fileName")
    }
}
