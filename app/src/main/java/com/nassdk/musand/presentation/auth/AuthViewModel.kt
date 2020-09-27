package com.nassdk.musand.presentation.auth

import com.nassdk.musand.domain.interactor.AuthInteractor
import com.nassdk.musand.presentation.global.BaseViewModel

class AuthViewModel(
    private val interactor: AuthInteractor
) : BaseViewModel() {

    override fun onBackPressed() = router.exit()
}