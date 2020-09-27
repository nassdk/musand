package com.nassdk.musand.di

import com.nassdk.musand.AppViewModel
import com.nassdk.musand.presentation.auth.AuthViewModel
import com.nassdk.musand.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { AppViewModel() }
    viewModel { SplashViewModel() }
    viewModel { AuthViewModel(get()) }
}