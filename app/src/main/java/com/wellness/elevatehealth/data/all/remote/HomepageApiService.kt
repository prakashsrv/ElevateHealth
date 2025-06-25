package com.wellness.elevatehealth.data.all.remote


import com.wellness.elevatehealth.data.all.model.HomepageResponse
import retrofit2.http.GET

interface HomepageApiService {
    @GET("73a05f08-7f81-49dc-8160-a9c3e6f5d162")
    suspend fun getHomepageData(): HomepageResponse
}