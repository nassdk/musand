package com.nassdk.musand.presentation.auth

import com.nassdk.musand.R
import com.nassdk.musand.presentation.global.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : BaseFragment() {

    override val resourceLayout = R.layout.screen_auth

    private val viewModel: AuthViewModel by viewModel()

    override fun onBackPressed() = viewModel.onBackPressed()

    companion object {
        fun newInstance() = AuthFragment()
    }
}