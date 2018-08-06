package com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.model

sealed class PokemonsViewState {
    object Loading : PokemonsViewState()
    class Error(val reason: String) : PokemonsViewState()
    object noPokemons : PokemonsViewState()
    class Success(val pokemons: List<PokemonVM>) : PokemonsViewState()
}