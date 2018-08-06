package com.example.diegojosuepachecorosas.demodiego.di.activity

import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.activity.PokemonActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [])
    abstract fun providesMainActivity(): PokemonActivity
}