package com.dvdmunckhof.aoc

import java.io.Reader

object Resources {

    fun readString(fileName: String): String {
        return resourceReader(fileName).readText().trimEnd()
    }

    fun readAsList(fileName: String): List<String> {
        return resourceReader(fileName).readLines()
    }

    fun readAsIntList(filename: String): List<Int> {
        return readAsList(filename).map(String::toInt)
    }

    fun readAsLongList(filename: String): List<Long> {
        return readAsList(filename).map(String::toLong)
    }

    fun readSingleIntList(filename: String): List<Int> {
        return readString(filename).split(",").map(String::toInt)
    }

    private fun resourceReader(fileName: String): Reader {
        return javaClass.classLoader.getResourceAsStream(fileName)?.reader()
            ?: throw IllegalArgumentException("Cannot find Resource: $fileName")
    }
}
