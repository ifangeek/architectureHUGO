package com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource

import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.entity.PokemonEntity
import io.reactivex.Observable

interface PokemonDatasource {

    fun allPokemon(limit: Int, offset: Int): Observable<List<PokemonEntity>>
}