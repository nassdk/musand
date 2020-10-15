package com.nassdk.musand.data

import com.nassdk.musand.data.models.AuthResponseNet
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("oauth/authorize")
    suspend fun authorize(
        @Query("client_id") clineId: String = "fa149426"
    ): AuthResponseNet
}