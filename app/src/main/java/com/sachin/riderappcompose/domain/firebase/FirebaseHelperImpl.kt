package com.apnamart.apnarider.domain.firebase

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain._base.BaseHelperImplNew
import com.apnamart.apnarider.domain.firebase.usecase.CreateFcmUseCase
import javax.inject.Inject

class FirebaseHelperImpl @Inject
constructor(dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    BaseHelperImplNew(dataHelper, dispatcherProvider), FirebaseHelper {
    override val createFcmUseCase: CreateFcmUseCase
        get() = CreateFcmUseCase(dataHelper = dataHelper, dispatcherProvider = dispatcherProvider)
}