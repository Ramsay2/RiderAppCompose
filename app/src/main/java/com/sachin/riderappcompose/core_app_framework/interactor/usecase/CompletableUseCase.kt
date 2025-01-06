package com.apnamart.apnarider.core_app_framework.interactor.usecase

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.sachin.riderappcompose.core_app_framework.interactor.State

abstract class CompletableUseCase<INPUT, OUTPUT>(private val dispatcherProvider: DispatcherProvider) {
    abstract suspend fun execute(input: INPUT): State<OUTPUT>
}