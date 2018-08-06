package com.example.diegojosuepachecorosas.demodiego.core.interactor

interface Interactor<in Params,out Type>{

    fun execute(params: Params): Type

    object None
}