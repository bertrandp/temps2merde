package com.bertrandp.features.main

import com.bertrandp.data.model.RainForecast
import com.bertrandp.features.base.MvpView

interface MainMvpView : MvpView {

    fun showPokemon(pokemon: List<String>)

    fun showForecast(rainForecast: RainForecast)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}