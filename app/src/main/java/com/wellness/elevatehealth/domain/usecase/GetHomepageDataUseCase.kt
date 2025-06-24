package com.wellness.elevatehealth.domain.usecase


import com.wellness.elevatehealth.data.repository.model.HomepageResponse
import com.wellness.elevatehealth.data.repository.repository.HomepageRepository
import com.wellness.elevatehealth.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHomepageDataUseCase @Inject constructor(
    private val repository: HomepageRepository
) {
    operator fun invoke(): Flow<Result<HomepageResponse>> {
        return repository.getHomepageData()
    }
}