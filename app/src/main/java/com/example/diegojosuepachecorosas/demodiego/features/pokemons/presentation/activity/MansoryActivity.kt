package com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.activity

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.diegojosuepachecorosas.demodiego.R
import com.example.diegojosuepachecorosas.demodiego.core.platform.BaseActivity
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.Utils.SpacesItemDecoration
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.adapter.RVMansoryAdapter
import kotlinx.android.synthetic.main.activity_mansory.*

class MansoryActivity : BaseActivity() {

    private lateinit var adapter : RVMansoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mansory)

        adapter = RVMansoryAdapter()
        var layout = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        rv_mansorys.layoutManager = layout
        rv_mansorys.adapter = adapter
//        var decoration  = SpacesItemDecoration(16)
//        rv_mansorys.addItemDecoration(decoration)


    }
}