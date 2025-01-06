package com.apnamart.apnarider.data.http

import com.apnamart.apnarider.data.http.services.AppInfoApiService
import com.apnamart.apnarider.data.http.services.AttendanceApiService
import com.sachin.riderappcompose.data.http.services.ConsumerAuthApiService
import com.apnamart.apnarider.data.http.services.FirebaseApiService
import com.apnamart.apnarider.data.http.services.OnboardingApiService
import com.apnamart.apnarider.data.http.services.PaymentApiService
import com.apnamart.apnarider.data.http.services.RiderCashCollectionApiService
import com.apnamart.apnarider.data.http.services.SaleApiService

interface ApiHelper :
    ConsumerAuthApiService,
    FirebaseApiService,
    AppInfoApiService,
    SaleApiService,
    AttendanceApiService,
    PaymentApiService,
    RiderCashCollectionApiService,
    OnboardingApiService