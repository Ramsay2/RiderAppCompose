package com.apnamart.apnarider.core_app_framework.interactor.usecase

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.core_app_framework.retrofit.RetrofitException
import com.sachin.riderappcompose.core_app_framework.interactor.State
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class SimpleUseCase<INPUT, OUTPUT, DATA>(private val dispatcherProvider: DispatcherProvider) {

    abstract suspend fun buildUseCase(input: INPUT): Response<DATA>

    abstract suspend fun onComplete(data: DATA): State<OUTPUT>

    open suspend fun execute(input: INPUT): State<OUTPUT> {
        return try {
            withContext(dispatcherProvider.io()) {
                val response = async { buildUseCase(input) }
                val data = response.await()
                if (data.isSuccessful) {
                    data.body()?.let {
                        onComplete(it)
                    } ?: kotlin.run { State.error(null, data.errorBody()) }
                } else {
                    State.error(
                        RetrofitException(
                            kind = RetrofitException.HTTP_ERROR,
                            exception = Throwable("Api error occurred"),
                            response = data
                        )
                    )
                }
            }
        } catch (e: java.lang.Exception) {
            State.error(e)
        }
    }
}