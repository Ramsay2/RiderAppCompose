package com.apnamart.apnarider.core_app_framework.interactor.usecase

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.sachin.riderappcompose.core_app_framework.interactor.State
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

abstract class FlowableUseCase<INPUT, OUTPUT, DATA>(private val dispatcherProvider: DispatcherProvider) {

    abstract suspend fun buildUseCase(input: INPUT): Response<DATA>

    abstract fun onComplete(data: DATA): State<OUTPUT>

    abstract val DELAY: Long


    suspend fun execute(input: INPUT): Flow<OUTPUT> {
        while (true) {
            val response = buildUseCase(input)
            flow<State<OUTPUT>> {
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(onComplete(it))
                    } ?: kotlin.run { emit(State.error(null, response.errorBody())) }
                } else {
                    emit(State.error(null, response.errorBody()))
                }
            }.catch {
                emit(State.error(null, response.errorBody()))
            }
            delay(DELAY)
        }

    }

}