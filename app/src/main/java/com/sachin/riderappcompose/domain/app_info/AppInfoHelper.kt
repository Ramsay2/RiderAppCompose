package com.apnamart.apnarider.domain.app_info

import com.apnamart.apnarider.domain.app_info.usecase.CheckAppUpdateUseCase

interface AppInfoHelper{
    val checkAppUpdateUseCase: CheckAppUpdateUseCase
}