package com.nassdk.musand.di

import com.nassdk.musand.data.base.ErrorHandler
import com.nassdk.musand.data.repositoryimpl.AuthRepositoryImpl
import com.nassdk.musand.domain.interactor.AuthInteractor
import com.nassdk.musand.domain.repository.AuthRepository
import org.koin.dsl.module

val domainModule = module {

    single { ErrorHandler() }

    single<AuthRepository> { AuthRepositoryImpl(get()) }

    single { AuthInteractor(get(), get()) }
}