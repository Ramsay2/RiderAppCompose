package com.apnamart.apnarider.domain.storage_file

import com.apnamart.apnarider.domain.storage_file.useCase.SetUniqueDeviceIdUseCase

interface StorageFileHelper {
    val setUniqueDeviceIdUseCase : SetUniqueDeviceIdUseCase
}