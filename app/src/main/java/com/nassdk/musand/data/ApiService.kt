package com.nassdk.musand.data

import com.nassdk.musand.domain.model.AuthResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("oauth/authorize")
    suspend fun authorize(
        @Query("client_id") clineId: String = "fa149426"
    ): AuthResponse
}