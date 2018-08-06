package com.example.diegojosuepachecorosas.demodiego.core.navigation

import android.content.Context
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.activity.PokemonActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor(){
    fun showMain(context: Context){
        context.startActivity(PokemonActivity.newInstance(context))
    }
}