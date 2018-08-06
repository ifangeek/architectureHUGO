package com.example.diegojosuepachecorosas.demodiego

import android.app.Activity
import android.app.Application
import com.example.diegojosuepachecorosas.demodiego.di.ApplicationComponent
import com.example.diegojosuepachecorosas.demodiego.di.DaggerApplicationComponent
import com.example.diegojosuepachecorosas.demodiego.di.api.ApiModule
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AndroidApplication : Application(),HasActivityInjector {


    @Inject
    internal lateinit var activityInjector : DispatchingAndroidInjector<Activity>


    val appComponent : ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE){
        DaggerApplicationComponent.builder()
                .application(this)
                .apiModule(ApiModule("https://pokeapi.co/api/v2/ "))
                .Build()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()
        injectMembers()
        initializeLeakDetection()
    }

    private fun injectMembers() = appComponent.inject(this)

    private fun initializeLeakDetection(){
        if(BuildConfig.DEBUG) LeakCanary.install(this)
    }
}