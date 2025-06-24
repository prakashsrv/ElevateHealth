package com.wellness.elevatehealth.di


import com.wellness.elevatehealth.data.repository.remote.HomepageApiService
import com.wellness.elevatehealth.data.repository.repository.HealthRepository
import com.wellness.elevatehealth.data.repository.repository.HomepageRepository
import com.wellness.elevatehealth.util.DispatcherProvider
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

    @Provides
    @Singleton
    fun provideHomepageRepository(
        apiService: HomepageApiService,
        dispatchers: DispatcherProvider
    ): HomepageRepository = HomepageRepository(apiService, dispatchers)
}