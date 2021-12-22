package com.dvdmunckhof.aoc.event2021

import kotlin.math.min

class Day16(input: String) {
    private val inputStream = HexInputStream(input)

    fun solvePart1(): Int {
        val packet = parsePacket()
        return solvePart1(packet)
    }

    private fun solvePart1(packet: Packet): Int {
        if (packet is OperatorPacket) {
            return packet.version + packet.subPackets.sumOf(this::solvePart1)
        }
        return packet.version
    }

    fun solvePart2(): Long {
        val packet = parsePacket()
        return solvePart2(packet)
    }

    private fun solvePart2(packet: Packet): Long {
        if (packet is LiteralPacket) {
            return packet.value
        }

        val values = (packet as OperatorPacket).subPackets.map(::solvePart2)

        return when (packet.type) {
            0 -> values.sum()
            1 -> values.fold(1L) { product, n -> product * n }
            2 -> values.minOf { it }
            3 -> values.maxOf { it }
            5 -> (values[0] > values[1]).toLong()
            6 -> (values[0] < values[1]).toLong()
            7 -> (values[0] == values[1]).toLong()
            else -> error("Invalid packet type: ${packet.type}")
        }
    }

    private fun parsePacket(): Packet {
        val version = inputStream.read(3)
        val type = inputStream.read(3)
        return if (type == 4) {
            parseLiteralPacket(version, type)
        } else {
            parseOperatorPacket(version, type)
        }
    }

    private fun parseOperatorPacket(version: Int, type: Int): OperatorPacket {
        val lengthType = inputStream.read(1)
        val subPackets = if (lengthType == 0) {
            val length = inputStream.read(15)
            val stop = inputStream.pos + length
            val list = mutableListOf<Packet>()
            while (inputStream.pos < stop) {
                list += parsePacket()
            }
            list
        } else {
            val length = inputStream.read(11)
            val list = mutableListOf<Packet>()
            for (i in 1..length) {
                list += parsePacket()
            }
            list
        }
        return OperatorPacket(version, type, subPackets)
    }

    private fun parseLiteralPacket(version: Int, type: Int): LiteralPacket {
        var result = 0L
        while (true) {
            val keepReading = inputStream.readBool()
            result = (result shl 4) or inputStream.read(4).toLong()

            if (!keepReading) {
                break
            }
        }

        return LiteralPacket(version, type, result)
    }

    private class HexInputStream(hex: String) {
        private val buffer = hex.map { Character.digit(it, 16) }
        private val end: Int = buffer.size shl 2
        var pos: Int = 0
            private set

        fun read(bits: Int): Int {
            check(bits in 1..31 && pos + bits <= end) { "illegal read (pos $pos, end $end, bits $bits)" }

            var result = 0
            var remaining = bits

            while (remaining > 0) {
                val index = pos ushr 2
                val offset = pos and 0x03
                val take = min(remaining, 4 - offset)
                remaining -= take
                val n = buffer[index] ushr (4 - take - offset) and (1 shl take) - 1
                result = result or (n shl remaining)
                pos += take
            }
            return result
        }

        fun readBool(): Boolean = read(1) == 1
    }

    private sealed interface Packet {
        val version: Int
        val type: Int
    }

    private data class OperatorPacket(
        override val version: Int,
        override val type: Int,
        val subPackets: List<Packet>,
    ) : Packet

    private data class LiteralPacket(
        override val version: Int,
        override val type: Int,
        val value: Long,
    ) : Packet

    private fun Boolean.toLong(): Long = if (this) 1L else 0L
}
