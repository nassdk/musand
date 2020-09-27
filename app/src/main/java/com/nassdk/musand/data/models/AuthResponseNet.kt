package com.nassdk.musand.data.models

import com.google.gson.annotations.SerializedName

data class AuthResponseNet(
    @SerializedName("access_token") val token: String,
    @SerializedName("expires_in") val expiresTime: String,
    @SerializedName("refresh_token") val refreshToken: String
)