package com.nassdk.musand.presentation.splash

import com.nassdk.musand.presentation.global.BaseViewModel
import com.nassdk.musand.presentation.global.Screens
import kotlinx.coroutines.*

class SplashViewModel : BaseViewModel() {

    init {
        GlobalScope.launch {
            delay(3000)

            withContext(Dispatchers.Main) {
                router.newRootChain(Screens.Authorization)
            }
        }
    }

    override fun onBackPressed() = router.exit()
}