package com.apnamart.apnarider.core_app_framework.ioc.qualifier

import androidx.work.ListenableWorker
import dagger.MapKey
import kotlin.reflect.KClass


@MapKey
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkerKey(val value: KClass<out ListenableWorker>)