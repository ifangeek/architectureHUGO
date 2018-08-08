package com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.adapter

import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diegojosuepachecorosas.demodiego.R
import com.example.diegojosuepachecorosas.demodiego.core.extension.load
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.model.PokemonVM
import kotlinx.android.synthetic.main.item_pokemon.view.*
class RVPokemonsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val LAYOUT_ONE : Int = 0
    val LAYOUT_TWO : Int = 1
    var isLoading: Boolean = false

    var data: MutableList<PokemonVM> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == LAYOUT_ONE){
            var v : View = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon,parent,false)
            return ViewHolder(v)
        }
        else {
            var v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_progressbar,parent,false)
            return ProgressHolder(v)
        }
    }

    override fun getItemCount() : Int {
        return if(!isLoading){
            data.size + 1
        }else {
            data.size
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
            if(holder.itemViewType == LAYOUT_ONE){
                holder  as ViewHolder
                holder.bindView(data[position])
            } else {
            }

    override fun getItemViewType(position: Int): Int {
        return if(position == itemCount - 1) LAYOUT_TWO
        else LAYOUT_ONE
    }

    fun addListPokemons(listPokemonVM: List<PokemonVM>){
        data.addAll(listPokemonVM)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(model: PokemonVM) {
            val imageView = itemView.iv_pokemon as AppCompatImageView
            imageView.load("http://pokeapi.co/media/sprites/pokemon/" + model.id + ".png")
            itemView.tv_pokemon.text = model.name

        }

    }

    inner class ProgressHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }


}

