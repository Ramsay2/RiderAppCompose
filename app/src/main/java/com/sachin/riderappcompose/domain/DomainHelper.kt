package com.apnamart.apnarider.domain

//import com.apnamart.apnarider.data.remote_config.RemoteConfigHelper
import com.apnamart.apnarider.domain.app_info.AppInfoHelper
import com.apnamart.apnarider.domain.attendance.AttendanceHelper
import com.apnamart.apnarider.domain.consumer_auth.ConsumerAuthHelper
import com.apnamart.apnarider.domain.firebase.FirebaseHelper
import com.apnamart.apnarider.domain.onboarding.OnboardingHelper
import com.apnamart.apnarider.domain.payment.PaymentHelper
import com.apnamart.apnarider.domain.rider_order.RiderOrderHelper
import com.apnamart.apnarider.domain.rider_transaction.RiderCashDepositHelper
import com.apnamart.apnarider.domain.storage_file.StorageFileHelper
import com.apnamart.apnarider.domain.user_location.UserLocationHelper
import com.sachin.riderappcompose.data.cache.CacheHelper
import javax.inject.Singleton

@Singleton
interface DomainHelper {

    val cache: CacheHelper
//    val config: RemoteConfigHelper

    /* Domains */
    val appInfoHelper: AppInfoHelper
    val consumerAuthHelper: ConsumerAuthHelper
    val firebaseHelper: FirebaseHelper
    val userLocationHelper: UserLocationHelper
    val attendanceHelper: AttendanceHelper
    val riderOrderHelper: RiderOrderHelper
    val paymentHelper: PaymentHelper
    val riderCashDepositHelper : RiderCashDepositHelper
    val onboardingHelper : OnboardingHelper
    val storageFileHelper : StorageFileHelper
}