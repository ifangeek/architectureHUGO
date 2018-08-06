package com.example.diegojosuepachecorosas.demodiego.features.pokemons.data.datasource.rest

import com.example.diegojosuepachecorosas.demodiego.core.mapper.Mapper
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.domain.entity.PokemonEntity


object ResultDataMapper : Mapper<ResultReponseData, List<PokemonEntity>> {
    override fun map(origin: ResultReponseData): List<PokemonEntity> {
        return origin.result.map { PokemonDataMapper.map(it) }
    }

}

object PokemonDataMapper : Mapper<PokemonResponseData, PokemonEntity> {
    override fun map(origin: PokemonResponseData): PokemonEntity {
        return PokemonEntity(
                origin.name,
                origin.url,
                origin.number
        )
    }
}