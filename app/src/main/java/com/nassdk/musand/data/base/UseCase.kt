package com.nassdk.musand.data.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.concurrent.CancellationException

abstract class UseCase<Type, in Params>(private val apiErrorHandler: ErrorHandler) where Type : Any {

    abstract suspend fun run(params: Params? = null): Type

    fun invoke(
        params: Params?,
        state: (UseCaseState<Type>)?
    ) {

        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = run(params)
                state?.success(result = result)
                Timber.d("Response: $result")
            } catch (e: CancellationException) {
                state?.error(errorModel = apiErrorHandler.proceed(e))
                Timber.d("Error: $e")
            } catch (e: Exception) {
                state?.error(errorModel = apiErrorHandler.proceed(e))
                Timber.d("Error: $e cause: ${e.cause}")
            }
        }
    }
}