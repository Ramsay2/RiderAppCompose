package com.apnamart.apnarider.domain.app_info

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain._base.BaseHelperImplNew
import com.apnamart.apnarider.domain.app_info.usecase.CheckAppUpdateUseCase
import javax.inject.Inject

class AppInfoHelperImpl @Inject
constructor(dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    BaseHelperImplNew(dataHelper, dispatcherProvider), AppInfoHelper {
    override val checkAppUpdateUseCase: CheckAppUpdateUseCase
        get() = CheckAppUpdateUseCase(
            dataHelper = dataHelper,
            dispatcherProvider = dispatcherProvider
        )
}