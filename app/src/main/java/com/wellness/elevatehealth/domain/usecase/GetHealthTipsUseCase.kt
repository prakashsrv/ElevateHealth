package com.wellness.elevatehealth.domain.usecase

import com.wellness.elevatehealth.data.repository.repository.HealthRepository
import com.wellness.elevatehealth.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case that retrieves health tips from the repository.
 */
class GetHealthTipsUseCase @Inject constructor(
    private val repository: HealthRepository
) {
    operator fun invoke(): Flow<Result<List<String>>> {
        return repository.getHealthTips()
    }
}