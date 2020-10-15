package com.nassdk.musand.domain.interactor

import com.nassdk.musand.data.base.ErrorHandler
import com.nassdk.musand.data.base.UseCase
import com.nassdk.musand.data.models.AuthResponseNet
import com.nassdk.musand.domain.repository.AuthRepository

class AuthInteractor(
    private val repository: AuthRepository,
    errorHandler: ErrorHandler
): UseCase<AuthResponseNet, Any?>(errorHandler){

    override suspend fun run(params: Any?) =  repository.makeAuth()
}