package com.apnamart.apnarider.domain._base

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper


open class BaseHelperImplNew(internal val dataHelper: DataHelper, internal val dispatcherProvider: DispatcherProvider)
