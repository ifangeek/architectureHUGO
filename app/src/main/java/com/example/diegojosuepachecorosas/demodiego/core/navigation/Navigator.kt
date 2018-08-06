package com.example.diegojosuepachecorosas.demodiego.core.navigation

import android.content.Context
import com.example.diegojosuepachecorosas.demodiego.features.main.MainActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor(){
    fun showMain(context: Context){
        context.startActivity(MainActivity.newIntent(context))
    }
}