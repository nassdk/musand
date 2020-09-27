package com.nassdk.musand

import com.nassdk.musand.presentation.global.BaseViewModel
import com.nassdk.musand.presentation.global.Screens

class AppViewModel : BaseViewModel() {

    init {
        router.newRootChain(Screens.Splash)
    }
}