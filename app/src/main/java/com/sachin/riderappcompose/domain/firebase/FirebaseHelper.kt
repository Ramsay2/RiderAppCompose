package com.apnamart.apnarider.domain.firebase

import com.apnamart.apnarider.domain.firebase.usecase.CreateFcmUseCase

interface FirebaseHelper{
    val createFcmUseCase: CreateFcmUseCase
}