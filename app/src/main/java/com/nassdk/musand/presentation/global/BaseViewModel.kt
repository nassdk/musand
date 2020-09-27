package com.nassdk.musand.presentation.global

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import org.koin.core.KoinComponent
import org.koin.core.inject
import ru.terrakok.cicerone.Router

abstract class BaseViewModel : ViewModel(), KoinComponent {

    private val scope by lazy {
        CoroutineScope(
            Job() + Dispatchers.Main
        )
    }

    val router: Router by inject()

    override fun onCleared() {
        super.onCleared()

        scope.cancel()
    }

    open fun onBackPressed() = router.exit()
}