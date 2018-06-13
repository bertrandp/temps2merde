package com.bertrandp.features.detail

import com.bertrandp.data.model.Pokemon
import com.bertrandp.data.model.Statistic
import com.bertrandp.features.base.MvpView

interface DetailMvpView : MvpView {

    fun showPokemon(pokemon: Pokemon)

    fun showStat(statistic: Statistic)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}