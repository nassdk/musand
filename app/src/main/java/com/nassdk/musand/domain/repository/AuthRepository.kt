package com.nassdk.musand.domain.repository

import com.nassdk.musand.data.models.AuthResponseNet

interface AuthRepository {
    suspend fun makeAuth(): AuthResponseNet
}