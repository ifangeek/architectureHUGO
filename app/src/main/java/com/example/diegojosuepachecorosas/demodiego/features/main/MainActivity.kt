package com.example.diegojosuepachecorosas.demodiego.features.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.diegojosuepachecorosas.demodiego.R
import com.example.diegojosuepachecorosas.demodiego.core.platform.BaseActivity
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.viewmodel.PokemonViewModel

class MainActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
