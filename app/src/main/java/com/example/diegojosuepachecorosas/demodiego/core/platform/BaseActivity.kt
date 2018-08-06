package com.example.diegojosuepachecorosas.demodiego.core.platform

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.example.diegojosuepachecorosas.demodiego.AndroidApplication
import com.example.diegojosuepachecorosas.demodiego.di.ApplicationComponent
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as AndroidApplication).appComponent
    }

    inline fun <reified  T: ViewModel> BaseActivity.getViewModel() :T{
        return ViewModelProviders.of(this,viewModelFactory)[T::class.java]
    }



}
