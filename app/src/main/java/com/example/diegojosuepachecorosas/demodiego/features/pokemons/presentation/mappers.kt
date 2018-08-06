package com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation

import com.example.diegojosuepachecorosas.demodiego.core.mapper.Mapper
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.entity.PokemonEntity
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.model.PokemonVM

object PokemonVMMapper : Mapper<PokemonEntity,PokemonVM>{
    override fun map(origin: PokemonEntity): PokemonVM {
        return PokemonVM(
                origin.name,
                origin.url,
                origin.id
        )
    }
}