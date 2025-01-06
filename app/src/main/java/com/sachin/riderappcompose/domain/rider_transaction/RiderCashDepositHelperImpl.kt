package com.apnamart.apnarider.domain.rider_transaction

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain._base.BaseHelperImplNew
import com.apnamart.apnarider.domain.rider_transaction.usecase.GetCashDepositStoreLevelUseCase
import com.apnamart.apnarider.domain.rider_transaction.usecase.GetRiderPayoutDateWiseDetailsUseCase
import com.apnamart.apnarider.domain.rider_transaction.usecase.GetRiderPayoutTotalDetailsUseCase
import com.apnamart.apnarider.domain.rider_transaction.usecase.RiderInHandCashDetailsUseCase
import com.apnamart.apnarider.domain.rider_transaction.usecase.RiderPendingCashUseCase
import javax.inject.Inject

class RiderCashDepositHelperImpl @Inject
constructor(dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    BaseHelperImplNew(dataHelper, dispatcherProvider), RiderCashDepositHelper {

    override val riderPendingCashUseCase: RiderPendingCashUseCase
        get() = RiderPendingCashUseCase(dataHelper)

    override val getCashDepositStoreLevelUseCase: GetCashDepositStoreLevelUseCase
        get() = GetCashDepositStoreLevelUseCase(dataHelper, dispatcherProvider)

    override val getRiderPayoutDetailsUseCase: GetRiderPayoutTotalDetailsUseCase
        get() = GetRiderPayoutTotalDetailsUseCase(dataHelper, dispatcherProvider)

    override val getRiderPayoutDateWiseDetailsUseCase: GetRiderPayoutDateWiseDetailsUseCase
        get() = GetRiderPayoutDateWiseDetailsUseCase(dataHelper)

    override val riderInHandCashDetailsUseCase: RiderInHandCashDetailsUseCase
        get() = RiderInHandCashDetailsUseCase(dataHelper, dispatcherProvider)
}