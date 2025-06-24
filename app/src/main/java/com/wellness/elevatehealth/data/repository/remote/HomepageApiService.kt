package com.wellness.elevatehealth.data.repository.remote


import com.wellness.elevatehealth.data.repository.model.HomepageResponse
import retrofit2.http.GET

interface HomepageApiService {
    @GET("homepage")
    suspend fun getHomepageData(): List<HomepageResponse>
}