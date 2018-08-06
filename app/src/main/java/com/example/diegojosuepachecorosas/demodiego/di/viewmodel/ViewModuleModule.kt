package com.example.diegojosuepachecorosas.demodiego.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.viewmodel.PokemonViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModuleModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PokemonViewModel::class)
    abstract fun bindsPokemonsViewModel(pokemonViewModel: PokemonViewModel): ViewModel


}
