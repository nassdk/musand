package com.nassdk.musand.data.base

import com.nassdk.musand.data.models.ErrorModel

interface UseCaseState<Type> {

    fun success(result: Type)
    fun error(errorModel: ErrorModel?)
}