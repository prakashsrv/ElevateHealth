package com.wellness.elevatehealth.data.repository.repository



import com.wellness.elevatehealth.data.repository.model.HomepageResponse
import com.wellness.elevatehealth.data.repository.remote.HomepageApiService
import com.wellness.elevatehealth.util.DispatcherProvider
import com.wellness.elevatehealth.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomepageRepository @Inject constructor(
    private val apiService: HomepageApiService,
    private val dispatchers: DispatcherProvider
) {
    fun getHomepageData(): Flow<Result<HomepageResponse>> = flow {
        emit(Result.Loading)

        try {
            val response = apiService.getHomepageData() // Now returns HomepageResponse directly
            emit(Result.Success(response))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }.flowOn(dispatchers.io)
}