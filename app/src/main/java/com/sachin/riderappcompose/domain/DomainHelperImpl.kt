package com.apnamart.apnarider.domain

import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
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
import javax.inject.Inject

class DomainHelperImpl
@Inject
internal constructor(
    override val cache: CacheHelper,
//    override val config: RemoteConfigHelper,
    override val consumerAuthHelper: ConsumerAuthHelper,
    override val firebaseHelper: FirebaseHelper,
    override val userLocationHelper: UserLocationHelper,
    override val appInfoHelper: AppInfoHelper,
    override val attendanceHelper: AttendanceHelper,
    override val riderOrderHelper: RiderOrderHelper,
    override val paymentHelper: PaymentHelper,
    override val riderCashDepositHelper: RiderCashDepositHelper,
    override val onboardingHelper: OnboardingHelper,
    override val storageFileHelper: StorageFileHelper
) : DomainHelper
