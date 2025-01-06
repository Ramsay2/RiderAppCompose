package com.sachin.riderappcompose.data.http.provider

import com.apnamart.apnarider.data.http.services.AppInfoApiService
import com.apnamart.apnarider.data.http.services.AttendanceApiService
import com.sachin.riderappcompose.data.http.services.ConsumerAuthApiService
import com.apnamart.apnarider.data.http.services.FirebaseApiService
import com.apnamart.apnarider.data.http.services.OnboardingApiService
import com.apnamart.apnarider.data.http.services.PaymentApiService
import com.apnamart.apnarider.data.http.services.RiderCashCollectionApiService
import com.apnamart.apnarider.data.http.services.SaleApiService

interface ApiServicesProvider {
    val consumerAuthApiService: ConsumerAuthApiService
    val firebaseApiService: FirebaseApiService
    val appInfoApiService: AppInfoApiService
    val saleApiService: SaleApiService
    val attendanceApiService: AttendanceApiService
    val paymentApiService: PaymentApiService
    val riderCashCollectionApiService: RiderCashCollectionApiService
    val onboardingApiService: OnboardingApiService
}