package com.nassdk.musand.presentation.auth

import androidx.lifecycle.Observer
import com.nassdk.musand.R
import com.nassdk.musand.presentation.global.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : BaseFragment() {

    override val resourceLayout = R.layout.screen_auth

    private val viewModel: AuthViewModel by viewModel()

    override fun setupViewModel() {

        with(viewModel) {

            loadingState.observe(this@AuthFragment, Observer { isLoading ->
                // TODO
            })

            errorState.observe(this@AuthFragment, Observer { errorMessage ->
                //TODO
            })

            makeAuth()
        }
    }

    override fun onBackPressed() = viewModel.onBackPressed()

    companion object {
        fun newInstance() = AuthFragment()
    }
}