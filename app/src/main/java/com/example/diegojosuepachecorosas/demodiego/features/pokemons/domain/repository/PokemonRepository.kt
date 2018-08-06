package com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.repository

import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.entity.PokemonEntity
import io.reactivex.Observable

interface PokemonRepository {
    fun allPokemons(limit:Int,offset:Int) : Observable<List<PokemonEntity>>
}