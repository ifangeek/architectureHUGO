package com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.Utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SpacesItemDecoration(var mSpace:Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        outRect!!.left = mSpace
        outRect!!.right = mSpace
        outRect!!.bottom = mSpace

        //añadir un margen solo para los primeros items ,evitando el doble espacio entre los elementos
        if(parent!!.getChildAdapterPosition(view) == 0) outRect.top = mSpace

    }
}