package com.sachin.riderappcompose.core_app_framework.interactor

import okhttp3.ResponseBody

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */
data class State<out T>(
    val status: Status,
    val data: T?,
    val throwable: Exception? = null,
    val errorBody: ResponseBody? = null
) {
    companion object {
        fun <T> success(data: T?): State<T> {
            return State(Status.SUCCESS, data)
        }

        fun <T> empty(): State<T> {
            return State(Status.SUCCESS, null)
        }

        fun <T> error(throwable: Exception? = null, errorBody: ResponseBody? = null): State<T> {
            return State(Status.ERROR, null, throwable, errorBody)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR
}
