package com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.activity

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.diegojosuepachecorosas.demodiego.R
import com.example.diegojosuepachecorosas.demodiego.core.platform.BaseActivity
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.adapter.RVPokemonsAdapter
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.model.PokemonsViewState
import com.example.diegojosuepachecorosas.demodiego.features.pokemons.presentation.viewmodel.PokemonViewModel
import kotlinx.android.synthetic.main.activity_main.*

class PokemonActivity : BaseActivity() {

    companion object {
        fun newInstance(context: Context) = Intent(context,PokemonActivity::class.java)
    }

    private val viewModel by lazy {
        getViewModel() as PokemonViewModel
    }

    private lateinit var adapter: RVPokemonsAdapter

    private var aptoCargar: Boolean = false

    private var offset: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = RVPokemonsAdapter()
        rv_pokemons.adapter = adapter
        var layout = GridLayoutManager(this, 3)
        rv_pokemons.layoutManager = layout
        layout.spanSizeLookup = object: GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (adapter.itemCount - 1 == position) return 3

                return 1
            }
        }

        rv_pokemons.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    val visibleItemCount = layout.childCount
                    val totalItemCount = layout.itemCount
                    val pastVisibleItem = layout.findFirstCompletelyVisibleItemPosition()

                    if (aptoCargar) {
                        if ((visibleItemCount + pastVisibleItem) >= totalItemCount) {
                            aptoCargar = false
                            viewModel.loadPokemons(20, offset)

                        }
                    }
                }
            }
        })

        aptoCargar = true

        viewModel.state.observe(this, Observer {
            it?.run {
                when (this) {
                    PokemonsViewState.Loading ->{
                        adapter.isLoading = true

                    }
                    is PokemonsViewState.Error -> {
                        adapter.isLoading = false


                    }
                    is PokemonsViewState.Success -> {
                        adapter.addListPokemons(pokemons)
                        offset += pokemons.size
                        aptoCargar = true
                        adapter.isLoading = false

                    }
                }
            }
        })


    }

    override fun onStart() {
        super.onStart()
        viewModel.loadPokemons(20,offset)
    }
}