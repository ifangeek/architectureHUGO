package com.example.diegojosuepachecorosas.demodiego.core.extension

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlin.coroutines.experimental.coroutineContext

fun ViewGroup.inflate(@LayoutRes res:Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(res,this,attachToRoot)
}

fun ImageView.load(url:String?){
    Picasso.get()
            .load(url)
            .into(this)
}