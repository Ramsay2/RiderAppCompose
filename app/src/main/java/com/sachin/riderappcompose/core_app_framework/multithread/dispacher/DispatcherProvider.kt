package com.apnamart.apnarider.core_app_framework.multithread.dispacher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun main(): CoroutineDispatcher

    fun io(): CoroutineDispatcher

    fun unconfined() : CoroutineDispatcher
}