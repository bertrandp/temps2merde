package com.bertrandp.data

import com.bertrandp.data.model.Pokemon
import com.bertrandp.data.model.RainForecast
import com.bertrandp.data.remote.MeteoFranceApi
import com.bertrandp.data.remote.PokemonApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject
constructor(private val mPokemonApi: PokemonApi, private val mMeteoFranceApi: MeteoFranceApi) {

    fun getPokemonList(limit: Int): Single<List<String>> {
        return mPokemonApi.getPokemonList(limit)
                .toObservable()
                .flatMapIterable { (results) -> results }
                .map { (name) -> name }
                .toList()
    }

    fun getPokemon(name: String): Single<Pokemon> {
        return mPokemonApi.getPokemon(name)
    }

    fun getLyonWhether(): Single<RainForecast> {
        val lyonForecast = mMeteoFranceApi.getLyonForecast()
        return lyonForecast
    }
}