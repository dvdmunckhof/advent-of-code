package com.dvdmunckhof.aoc.event2022

import kotlin.math.max

class Day19(input: List<String>) {
    private val blueprints = input.map { line ->
        val numberRegex = Regex("-?\\d+")
        val numbers = numberRegex.findAll(line).map { it.groupValues.first().toInt() }.toList()
        Blueprint(
            numbers[0],
            listOf(
                Product(ProductType.GEODE, Inventory(geode = 1), Inventory(ore = numbers[5], obsidian = numbers[6])),
                Product(ProductType.OBSIDIAN, Inventory(obsidian = 1), Inventory(ore = numbers[3], clay = numbers[4])),
                Product(ProductType.CLAY, Inventory(clay = 1), Inventory(ore = numbers[2])),
                Product(ProductType.ORE, Inventory(ore = 1), Inventory(ore = numbers[1])),
            ),
        )
    }

    fun solvePart1(): Int {
        return blueprints.fold(0) { acc, blueprint -> acc + blueprint.index * blueprint.calculateBestResult(24) }
    }

    fun solvePart2(): Int {
        return blueprints.take(3).fold(1) { acc, blueprint -> acc * blueprint.calculateBestResult(32) }
    }

    private data class Blueprint(
        val index: Int,
        val products: List<Product>,
    ) {
        fun calculateBestResult(time: Int): Int {
            val initialState = State(Inventory(ore = 1), Inventory())
            val simulator = Simulator(this)
            simulator.simulate(initialState, initialState, time)
            return simulator.bestResult
        }
    }

    private data class State(
        val robots: Inventory,
        val materials: Inventory,
    ) {
        operator fun plus(product: Product): State {
            return State(this.robots + product.output, this.materials - product.materials)
        }

        fun canAfford(product: Product): Boolean {
            return this.materials.ore >= product.materials.ore &&
                    this.materials.clay >= product.materials.clay &&
                    this.materials.obsidian >= product.materials.obsidian &&
                    this.materials.geode >= product.materials.geode
        }
    }

    private data class Product(
        val type: ProductType,
        val output: Inventory,
        val materials: Inventory,
    )

    private data class Inventory(
        val ore: Int = 0,
        val clay: Int = 0,
        val obsidian: Int = 0,
        val geode: Int = 0,
    ) {
        operator fun plus(other: Inventory) = Inventory(
            this.ore + other.ore,
            this.clay + other.clay,
            this.obsidian + other.obsidian,
            this.geode + other.geode,
        )

        operator fun minus(other: Inventory) = Inventory(
            this.ore - other.ore,
            this.clay - other.clay,
            this.obsidian - other.obsidian,
            this.geode - other.geode,
        )

        operator fun get(type: ProductType) = when(type) {
            ProductType.ORE -> this.ore
            ProductType.CLAY -> this.clay
            ProductType.OBSIDIAN -> this.obsidian
            ProductType.GEODE -> this.geode
        }
    }

    private class Simulator(val blueprint: Blueprint) {
        private val maxMaterials = ProductType.values()
            .map { type -> blueprint.products.maxOf { it.materials[type] } }

        var bestResult = 0
            private set

        fun simulate(previousState: State, state: State, timeRemaining: Int) {
            if (timeRemaining == 0) {
                this.bestResult = max(this.bestResult, state.materials.geode)
                return
            }

            if (this.bestResult >= bestPossibleResult(state, timeRemaining)) {
                return
            }

            val nextState = state.copy(materials = state.materials + state.robots)
            for (product in blueprint.products) {
                if (!state.canAfford(product) || hasMaxRobots(product.type, state)) {
                    continue
                }
                if (previousState.canAfford(product) && state.robots == previousState.robots) {
                    continue
                }

                simulate(state, nextState + product, timeRemaining - 1)
                if (product.type == ProductType.GEODE) {
                    return
                }
            }

            simulate(state, nextState, timeRemaining - 1)
        }

        private fun hasMaxRobots(type: ProductType, state: State): Boolean {
            return type != ProductType.GEODE && this.maxMaterials[type] <= state.robots[type]
        }

        private fun bestPossibleResult(state: State, timeRemaining: Int): Int {
            val averageRobots = state.robots.geode + 1 + ((timeRemaining - 1) / 2.0)
            val geodes = state.materials.geode + averageRobots * timeRemaining
            return geodes.toInt()
        }

        private operator fun <T> List<T>.get(type: ProductType) = this[type.ordinal]
    }

    private enum class ProductType {
        ORE,
        CLAY,
        OBSIDIAN,
        GEODE,
    }
}
