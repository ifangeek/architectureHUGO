package com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource.rest

import com.example.diegojosuepachecorosas.demodiego.core.rest.BaseRestDatasource
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource.PokemonDatasource
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource.rest.api.PokemonService
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.entity.PokemonEntity
import io.reactivex.Observable
import javax.inject.Inject

class PokemonRestDatasource
@Inject constructor(private val pokemonService: PokemonService): BaseRestDatasource(),PokemonDatasource{
    override fun allPokemon(limit: Int, offset: Int): Observable<List<PokemonEntity>> {
        return parseResult(pokemonService.allPokemons(limit,offset))
                .map(ResultDataMapper::map)
                .toObservable()
    }


}