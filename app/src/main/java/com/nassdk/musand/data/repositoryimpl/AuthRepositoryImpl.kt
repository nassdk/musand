package com.nassdk.musand.data.repositoryimpl

import com.nassdk.musand.data.ApiService
import com.nassdk.musand.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val api: ApiService
) : AuthRepository {

    override suspend fun makeAuth() = api.authorize()
}