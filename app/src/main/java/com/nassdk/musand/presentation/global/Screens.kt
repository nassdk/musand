package com.nassdk.musand.presentation.global

import com.nassdk.musand.presentation.auth.AuthFragment
import com.nassdk.musand.presentation.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object Splash : SupportAppScreen() {
        override fun getFragment() = SplashFragment.newInstance()
    }

    object Authorization : SupportAppScreen() {
        override fun getFragment() = AuthFragment.newInstance()
    }
}