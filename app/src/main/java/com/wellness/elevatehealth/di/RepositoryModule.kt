package com.wellness.elevatehealth.di

import com.wellness.elevatehealth.data.repository.HealthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideHealthRepository(
        repository: HealthRepository
    ): HealthRepository = repository
}