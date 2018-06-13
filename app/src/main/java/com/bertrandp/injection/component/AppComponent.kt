package com.bertrandp.injection.component

import android.app.Application
import android.content.Context
import dagger.Component
import com.bertrandp.data.DataManager
import com.bertrandp.data.remote.PokemonApi
import com.bertrandp.injection.ApplicationContext
import com.bertrandp.injection.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun pokemonApi(): PokemonApi
}
