package com.bertrandp.data.remote

import com.bertrandp.data.model.RainForecast
import io.reactivex.Single
import retrofit2.http.GET

interface MeteoFranceApi {

    @GET("http://www.meteofrance.com/mf3-rpc-portlet/rest/pluie/691230")
    fun getLyonForecast(): Single<RainForecast>

}
