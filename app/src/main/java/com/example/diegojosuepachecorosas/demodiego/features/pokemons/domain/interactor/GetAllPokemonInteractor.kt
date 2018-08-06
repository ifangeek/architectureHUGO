package com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.interactor

import com.example.diegojosuepachecorosas.demodiego.core.interactor.Interactor
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.entity.PokemonEntity
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.repository.PokemonRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetAllPokemonInteractor
@Inject constructor(private val pokemonRepository: PokemonRepository) : Interactor<GetAllPokemonInteractor.Params,Observable<List<PokemonEntity>>>{
    override fun execute(params: Params): Observable<List<PokemonEntity>> {
       return pokemonRepository.allPokemons(params.limit,params.offset)
    }


    data class Params(val limit:Int,val offset:Int)
}