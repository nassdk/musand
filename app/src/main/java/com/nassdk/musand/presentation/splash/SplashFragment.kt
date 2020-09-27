package com.nassdk.musand.presentation.splash

import com.nassdk.musand.R
import com.nassdk.musand.presentation.global.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment() {

    override val resourceLayout = R.layout.screen_splash

    private val viewModel: SplashViewModel by viewModel()

    override fun onBackPressed() = viewModel.onBackPressed()

    override fun init() {
        run { viewModel }
    }

    companion object {
        fun newInstance() = SplashFragment()
    }
}