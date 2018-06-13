package com.bertrandp.injection.module

import com.bertrandp.data.remote.MeteoFranceApi
import dagger.Module
import dagger.Provides
import com.bertrandp.data.remote.PokemonApi
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by shivam on 8/7/17.
 */
@Module(includes = arrayOf(NetworkModule::class))
class ApiModule {

    @Provides
    @Singleton
    internal fun providePokemonApi(retrofit: Retrofit): PokemonApi =
            retrofit.create(PokemonApi::class.java)

    @Provides
    @Singleton
    internal fun provideMeteoFranceApi(retrofit: Retrofit): MeteoFranceApi =
            retrofit.create(MeteoFranceApi::class.java)
}