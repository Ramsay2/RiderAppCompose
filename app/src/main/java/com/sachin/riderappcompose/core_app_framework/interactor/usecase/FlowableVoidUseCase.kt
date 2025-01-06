package com.apnamart.apnarider.core_app_framework.interactor.usecase

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import kotlinx.coroutines.flow.Flow

abstract class FlowableVoidUseCase<OUTPUT, DATA>(dispatcherProvider: DispatcherProvider) :
    FlowableUseCase<Unit, OUTPUT, DATA>(dispatcherProvider) {

    open suspend fun execute(): Flow<OUTPUT> {
        return execute(Unit)
    }
}