package com.apnamart.apnarider.core_app_framework.ioc.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class StorageInfo(val value: String = "")