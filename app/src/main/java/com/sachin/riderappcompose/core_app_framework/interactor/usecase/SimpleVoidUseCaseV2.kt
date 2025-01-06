package com.apnamart.apnarider.core_app_framework.interactor.usecase

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.sachin.riderappcompose.core_app_framework.interactor.State

abstract class SimpleVoidUseCaseV2<OUTPUT, DATA>(private val dispatcherProvider: DispatcherProvider) :
    SimpleUseCaseV2<Unit, OUTPUT, DATA>(dispatcherProvider) {

    open suspend fun execute(): State<OUTPUT> {
        return execute(Unit)
    }
}