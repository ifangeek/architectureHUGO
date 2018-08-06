package com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource.rest.api

import com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource.rest.ResultReponseData
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    fun allPokemons(@Query("limit") limit: Int, @Query("offset") offset: Int): Single<Response<ResultReponseData>>
}