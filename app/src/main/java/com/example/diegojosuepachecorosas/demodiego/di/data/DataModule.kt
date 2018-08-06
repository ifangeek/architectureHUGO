package com.example.diegojosuepachecorosas.demodiego.di.data

import com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource.PokemonDatasource
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource.rest.PokemonRestDatasource
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.repository.PokemonRepositoryImpl
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun providePokemonDatasource(impl: PokemonRestDatasource): PokemonDatasource

    @Binds
    abstract fun providePokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository
}