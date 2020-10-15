package com.nassdk.musand.presentation.auth

import androidx.lifecycle.MutableLiveData
import com.nassdk.musand.data.base.UseCaseState
import com.nassdk.musand.data.models.AuthResponseNet
import com.nassdk.musand.data.models.ErrorModel
import com.nassdk.musand.domain.interactor.AuthInteractor
import com.nassdk.musand.presentation.global.BaseViewModel

class AuthViewModel(
    private val interactor: AuthInteractor
) : BaseViewModel() {

    val errorState = MutableLiveData<String>()
    val loadingState = MutableLiveData<Boolean>()

    fun makeAuth() {

        loadingState.postValue(true)

        interactor.invoke(null, object : UseCaseState<AuthResponseNet> {
            override fun success(result: AuthResponseNet) {

                loadingState.postValue(false)
//                router.newRootScreen() //TODO
            }

            override fun error(errorModel: ErrorModel?) {
                loadingState.postValue(false)
                errorState.postValue(errorModel?.getErrorMessage())
            }

        })

    }

    override fun onBackPressed() = router.exit()
}