package com.apnamart.apnastore.presentation_di.ioc.factory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class WorkerProviderFactory @Inject constructor(
    private val workerFactories: Map<Class<out ListenableWorker>, @JvmSuppressWildcards Provider<ChildWorkerFactory>>
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        try {
            val foundEntry =
                workerFactories.entries.find {
                    Class.forName(workerClassName).isAssignableFrom(it.key)
                }
            return foundEntry?.value?.get()?.create(appContext, workerParameters)
        } catch (e: Exception) {
            return null
        }
    }

    interface ChildWorkerFactory {
        fun create(appContext: Context, params: WorkerParameters): ListenableWorker
    }
}