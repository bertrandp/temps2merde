package com.bertrandp.data.model

import com.google.gson.annotations.SerializedName

class RainForecast {

    @SerializedName("echeance")
    var startDate: String? = null

    @SerializedName("lastUpdate")
    val lastUpdate: String? = null

    @SerializedName("niveauPluieText")
    val rainLevelLabel: List<String>? = null

}
