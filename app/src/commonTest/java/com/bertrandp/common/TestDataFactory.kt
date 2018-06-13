package com.bertrandp.common

import com.bertrandp.data.model.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Factory class that makes instances of data models with random field values.
 * The aim of this class is to help setting up test fixtures.
 */
object TestDataFactory {

    private val sRandom = Random()

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun makePokemon(id: String): Pokemon {
        return Pokemon(id, randomUuid() + id, makeSprites(), makeStatisticList(3))
    }

    fun makeLyonForecast(): RainForecast {
        return RainForecast("201806130000", "23h50", makeRainLevelLabel(), makeRainData())
    }

    private fun makeRainData(): List<RainData> {
        val data = ArrayList<RainData>()
        data.add(RainData("Précipitations faibles", 2, "5ec5ed"))
        for (i in 1..11) {
            data.add(RainData("Précipitations modérées", 3, "009ee0"))
        }
        return data
    }

    private fun makeRainLevelLabel(): List<String> {
        val labels = ArrayList<String>()
        labels.add("De00h00 à 00h05 : Précipitations faibles")
        labels.add("De00h05 à 01h00 : Précipitations modérées")
        return labels
    }

    fun makePokemonNamesList(count: Int): List<String> {
        val pokemonList = ArrayList<String>()
        for (i in 0..count - 1) {
            pokemonList.add(makePokemon(i.toString()).name)
        }
        return pokemonList
    }

    fun makePokemonNameList(pokemonList: List<NamedResource>): List<String> {
        val names = ArrayList<String>()
        for (pokemon in pokemonList) {
            names.add(pokemon.name)
        }
        return names
    }

    fun makeStatistic(): Statistic {
        val statistic = Statistic()
        statistic.baseStat = sRandom.nextInt()
        statistic.stat = makeNamedResource(randomUuid())
        return statistic
    }

    fun makeStatisticList(count: Int): List<Statistic> {
        val statisticList = ArrayList<Statistic>()
        for (i in 0..count - 1) {
            statisticList.add(makeStatistic())
        }
        return statisticList
    }

    fun makeSprites(): Sprites {
        val sprites = Sprites()
        sprites.frontDefault = randomUuid()
        return sprites
    }

    fun makeNamedResource(unique: String): NamedResource {
        return NamedResource(randomUuid() + unique, randomUuid())
    }

    fun makeNamedResourceList(count: Int): List<NamedResource> {
        val namedResourceList = (0..count - 1).map { makeNamedResource(it.toString()) }
        return namedResourceList
    }
}