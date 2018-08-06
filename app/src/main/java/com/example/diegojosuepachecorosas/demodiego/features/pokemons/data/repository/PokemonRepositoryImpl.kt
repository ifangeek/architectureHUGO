package com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.repository

import com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource.PokemonDatasource
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.repository.PokemonRepository
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.entity.PokemonEntity
import io.reactivex.Observable
import javax.inject.Inject

class PokemonRepositoryImpl
@Inject constructor(private val pokemonDatasource: PokemonDatasource) : PokemonRepository {
    override fun allPokemons(limit: Int, offset: Int): Observable<List<PokemonEntity>> {
        return pokemonDatasource.allPokemon(limit, offset)
    }
}