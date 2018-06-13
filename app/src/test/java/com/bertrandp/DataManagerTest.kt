package com.bertrandp

import com.bertrandp.common.TestDataFactory
import com.bertrandp.data.DataManager
import com.bertrandp.data.model.PokemonListResponse
import com.bertrandp.data.remote.MeteoFranceApi
import com.bertrandp.data.remote.PokemonApi
import com.bertrandp.util.RxSchedulersOverrideRule
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DataManagerTest {

    @Rule @JvmField val mOverrideSchedulersRule = RxSchedulersOverrideRule()
    @Mock lateinit var mMockPokemonApi: PokemonApi
    @Mock lateinit var mMockMeteoFranceApi: MeteoFranceApi

    private var mDataManager: DataManager? = null

    @Before
    fun setUp() {
        mDataManager = DataManager(mMockPokemonApi, mMockMeteoFranceApi)
    }

    @Test
    fun getPokemonListCompletesAndEmitsPokemonList() {
        val namedResourceList = TestDataFactory.makeNamedResourceList(5)
        val pokemonListResponse = PokemonListResponse(namedResourceList)

        `when`(mMockPokemonApi.getPokemonList(anyInt()))
                .thenReturn(Single.just(pokemonListResponse))

        mDataManager?.getPokemonList(10)
                ?.test()
                ?.assertComplete()
                ?.assertValue(TestDataFactory.makePokemonNameList(namedResourceList))
    }

    @Test
    fun getPokemonCompletesAndEmitsPokemon() {
        val name = "charmander"
        val pokemon = TestDataFactory.makePokemon(name)
        `when`(mMockPokemonApi.getPokemon(anyString()))
                .thenReturn(Single.just(pokemon))

        mDataManager?.getPokemon(name)
                ?.test()
                ?.assertComplete()
                ?.assertValue(pokemon)
    }

    @Test
    fun getLyonForecast() {
        val lyonForecast = TestDataFactory.makeLyonForecast()
        `when`(mMockMeteoFranceApi.getLyonForecast())
                .thenReturn(Single.just(lyonForecast))

        mDataManager?.getLyonWhether()
                ?.test()
                ?.assertComplete()
                ?.assertValue(lyonForecast)
    }
}
