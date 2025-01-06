package com.apnamart.apnarider.domain.consumer_auth.usecase

import com.apnamart.apnarider.core_app_framework.interactor.usecase.CompletableVoidUseCase
import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.sachin.riderappcompose.core_app_framework.interactor.State

class CleanUserDataUseCase(
    private val dataHelper: DataHelper,
    dispatcherProvider: DispatcherProvider
) : CompletableVoidUseCase<Unit>(dispatcherProvider) {


    override suspend fun execute(): State<Unit> {
        return State.success(dataHelper.clearUserData())
    }

}