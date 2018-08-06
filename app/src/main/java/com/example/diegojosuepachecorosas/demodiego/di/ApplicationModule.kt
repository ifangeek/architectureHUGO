package com.example.diegojosuepachecorosas.demodiego.di

import com.example.diegojosuepachecorosas.demodiego.core.scheduler.BaseSchedulerProvider
import com.example.diegojosuepachecorosas.demodiego.core.scheduler.SchedulerProvider
import com.example.diegojosuepachecorosas.demodiego.di.api.ApiModule
import com.example.diegojosuepachecorosas.demodiego.di.viewmodel.ViewModuleModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ApiModule::class,ViewModuleModule::class])
class ApplicationModule {

    @Singleton
    @Provides
    fun providesScheduler(provider:SchedulerProvider) : BaseSchedulerProvider{
        return provider
    }
}