package com.apnamart.apnarider.domain.rider_transaction

import com.apnamart.apnarider.domain.rider_transaction.usecase.GetCashDepositStoreLevelUseCase
import com.apnamart.apnarider.domain.rider_transaction.usecase.GetRiderPayoutDateWiseDetailsUseCase
import com.apnamart.apnarider.domain.rider_transaction.usecase.GetRiderPayoutTotalDetailsUseCase
import com.apnamart.apnarider.domain.rider_transaction.usecase.RiderInHandCashDetailsUseCase
import com.apnamart.apnarider.domain.rider_transaction.usecase.RiderPendingCashUseCase

interface RiderCashDepositHelper {
    val riderPendingCashUseCase: RiderPendingCashUseCase
    val getCashDepositStoreLevelUseCase: GetCashDepositStoreLevelUseCase
    val getRiderPayoutDetailsUseCase : GetRiderPayoutTotalDetailsUseCase
    val getRiderPayoutDateWiseDetailsUseCase :GetRiderPayoutDateWiseDetailsUseCase
    val riderInHandCashDetailsUseCase : RiderInHandCashDetailsUseCase

}