package com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diegojosuepachecorosas.demodiego.R
import kotlinx.android.synthetic.main.item_mansory.view.*

class RVMansoryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var imgList = listOf(R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten)

    var nameList = listOf("One","Two","Three","Four","Five","Six","Seven","Eigth","Nine","Ten")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.item_mansory,parent,false)
        return RVMansoryView(v)

    }

    override fun getItemCount(): Int {
       return nameList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.iv_image.setImageResource(imgList[position])
        holder.itemView.tv_titleImage.text = nameList[position]
    }

    inner class RVMansoryView(itemView : View) : RecyclerView.ViewHolder(itemView){

    }
}