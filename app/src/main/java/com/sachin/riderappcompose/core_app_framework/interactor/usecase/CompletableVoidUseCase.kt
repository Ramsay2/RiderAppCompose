package com.apnamart.apnarider.core_app_framework.interactor.usecase

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.sachin.riderappcompose.core_app_framework.interactor.State

abstract class CompletableVoidUseCase<OUTPUT>(private val dispatcherProvider: DispatcherProvider) {
    //TODO figure out if can add onComplete()
    abstract suspend fun execute(): State<OUTPUT>
}