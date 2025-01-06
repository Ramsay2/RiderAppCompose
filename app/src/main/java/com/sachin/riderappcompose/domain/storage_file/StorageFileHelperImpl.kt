package com.apnamart.apnarider.domain.storage_file

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain._base.BaseHelperImplNew
import com.apnamart.apnarider.domain.storage_file.useCase.SetUniqueDeviceIdUseCase
import javax.inject.Inject

class StorageFileHelperImpl @Inject
constructor(dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    BaseHelperImplNew(dataHelper, dispatcherProvider), StorageFileHelper {

    override val setUniqueDeviceIdUseCase: SetUniqueDeviceIdUseCase
        get() = SetUniqueDeviceIdUseCase(dataHelper, dispatcherProvider)


}