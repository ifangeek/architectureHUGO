package com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.adapter

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.util.Log.d
import android.view.View
import android.view.ViewGroup
import com.example.diegojosuepachecorosas.demodiego.R
import com.example.diegojosuepachecorosas.demodiego.core.extension.inflate
import com.example.diegojosuepachecorosas.demodiego.core.extension.load
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.model.PokemonVM
import kotlinx.android.synthetic.main.item_pokemon.view.*

class RVPokemonsAdapter : RecyclerView.Adapter<RVPokemonsAdapter.ViewHolder>() {

    var data: List<PokemonVM> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_pokemon))
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(data[position])
        d("imageview",data[position].url +"\n"+ data[position].name)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(model: PokemonVM) {
            val imageView = itemView.iv_pokemon as AppCompatImageView
            imageView.load("http://pokeapi.co/media/sprites/pokemon/" + model.id + ".png")
            d("imageview","http://pokeapi.co/media/sprites/pokemon/" + model.id + ".png")

        }

    }

}