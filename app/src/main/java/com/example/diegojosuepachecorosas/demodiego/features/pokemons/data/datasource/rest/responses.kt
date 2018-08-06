package com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource.rest

import com.google.gson.annotations.SerializedName

data class ResultReponseData(
        @SerializedName("results")
        val result: ArrayList<PokemonResponseData> = ArrayList()
)

data class PokemonResponseData(
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
) {
    val number: Int
        get() {
            val split = url.split("/")
            return split[split.size - 2].toInt()
        }

}