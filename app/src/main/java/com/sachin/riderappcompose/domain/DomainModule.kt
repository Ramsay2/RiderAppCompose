package com.sachin.riderappcompose.domain

import com.apnamart.apnarider.domain.DomainHelper
import com.apnamart.apnarider.domain.DomainHelperImpl
import com.apnamart.apnarider.domain.app_info.AppInfoHelper
import com.apnamart.apnarider.domain.app_info.AppInfoHelperImpl
import com.apnamart.apnarider.domain.attendance.AttendanceHelper
import com.apnamart.apnarider.domain.attendance.AttendanceHelperImpl
import com.apnamart.apnarider.domain.consumer_auth.ConsumerAuthHelper
import com.apnamart.apnarider.domain.consumer_auth.ConsumerAuthHelperImpl
import com.apnamart.apnarider.domain.firebase.FirebaseHelper
import com.apnamart.apnarider.domain.firebase.FirebaseHelperImpl
import com.apnamart.apnarider.domain.onboarding.OnboardingHelper
import com.apnamart.apnarider.domain.onboarding.OnboardingHelperImpl
import com.apnamart.apnarider.domain.payment.PaymentHelper
import com.apnamart.apnarider.domain.payment.PaymentHelperImpl
import com.apnamart.apnarider.domain.rider_order.RiderOrderHelper
import com.apnamart.apnarider.domain.rider_order.RiderOrderHelperImpl
import com.apnamart.apnarider.domain.rider_transaction.RiderCashDepositHelper
import com.apnamart.apnarider.domain.rider_transaction.RiderCashDepositHelperImpl
import com.apnamart.apnarider.domain.storage_file.StorageFileHelper
import com.apnamart.apnarider.domain.storage_file.StorageFileHelperImpl
import com.apnamart.apnarider.domain.user_location.UserLocationHelper
import com.apnamart.apnarider.domain.user_location.UserLocationHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun contributeUseCaseManager(useCaseManager: DomainHelperImpl): DomainHelper {
        return useCaseManager
    }

    @Provides
    fun contributeConsumerAuthHelper(consumerAuthHelper: ConsumerAuthHelperImpl): ConsumerAuthHelper {
        return consumerAuthHelper
    }

    @Provides
    fun contributeFirebaseHelper(firebaseHelper: FirebaseHelperImpl): FirebaseHelper {
        return firebaseHelper
    }

    @Provides
    fun contributeAppInfoHelper(appInfoHelper: AppInfoHelperImpl): AppInfoHelper {
        return appInfoHelper
    }

    @Provides
    fun contributeAttendanceHelper(attendanceHelper: AttendanceHelperImpl): AttendanceHelper {
        return attendanceHelper
    }

    @Provides
    fun contributeRiderOrderHelper(riderOrderHelper: RiderOrderHelperImpl): RiderOrderHelper {
        return riderOrderHelper
    }

    @Provides
    fun contributePaymentHelper(paymentHelper: PaymentHelperImpl): PaymentHelper {
        return paymentHelper
    }

    @Provides
    fun contributeRiderCashDepositHelper(riderCashDepositHelper: RiderCashDepositHelperImpl): RiderCashDepositHelper {
        return riderCashDepositHelper
    }

    @Provides
    fun contributeOnboardingHelper(onboardingHelper: OnboardingHelperImpl): OnboardingHelper {
        return onboardingHelper
    }

    @Provides
    fun contributeRiderLocationHelper(userLocationHelper: UserLocationHelperImpl): UserLocationHelper {
        return userLocationHelper
    }

    @Provides
    fun contributeStoreExternalFileHelper(storageFileHelper: StorageFileHelperImpl): StorageFileHelper {
        return storageFileHelper
    }
}