package com.example.utils

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UtilsModule {

    @Singleton
    @Provides
    fun provideTimeFormatter(): TimeFormatter = TimeFormatter
}