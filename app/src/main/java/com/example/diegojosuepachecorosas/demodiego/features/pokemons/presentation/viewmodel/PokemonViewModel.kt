package com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.diegojosuepachecorosas.demodiego.core.scheduler.BaseSchedulerProvider
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.interactor.GetAllPokemonInteractor
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.PokemonVMMapper
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.model.PokemonsViewState
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PokemonViewModel
@Inject constructor(private val schedulerProvider: BaseSchedulerProvider,
                    private val getAllPokemonInteractor: GetAllPokemonInteractor) : ViewModel(){

    private val disposables = CompositeDisposable()
    val state = MutableLiveData<PokemonsViewState>()

    fun loadPokemons(limit:Int,offset:Int){
            disposables.add(getAllPokemonInteractor.execute(GetAllPokemonInteractor.Params(limit,offset))
                    .delay(3,TimeUnit.SECONDS)
                    .map { PokemonVMMapper.map(it) }
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .doOnSubscribe{state.value = PokemonsViewState.Loading}
                    .subscribe({
                        if(it.isEmpty()){
                            state.value = PokemonsViewState.noPokemons
                        } else {
                            state.value = PokemonsViewState.Success(it)
                        }
                    }, {
                        state.value = PokemonsViewState.Error("Error al conectar con el servidor")
                    }))
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}