package com.apnamart.apnarider.domain.rider_transaction.mapper

import com.apnamart.apnarider.data.http.response.payout_details.DateWiseDataResponse
import com.apnamart.apnarider.data.http.response.payout_details.PayoutBreakdownResponse
import com.apnamart.apnarider.data.http.response.payout_details.PayoutTotalDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderCashDepositStoreLevelResponse
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderInHandCashDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_cash_collection.RiderPendingDepositResponse
import com.apnamart.apnarider.data.http.response.rider_cash_collection.StoreCashCollectionResponse
import com.apnamart.apnarider.domain.rider_transaction.entity.DateWisePayoutDetailsDomain
import com.apnamart.apnarider.domain.rider_transaction.entity.PayoutBreakdownDomain
import com.apnamart.apnarider.domain.rider_transaction.entity.PayoutTotalDetailsModal
import com.apnamart.apnarider.domain.rider_transaction.entity.RiderCashDepositStoreLevelDomain
import com.apnamart.apnarider.domain.rider_transaction.entity.RiderInHandCashDetailsDomain
import com.apnamart.apnarider.domain.rider_transaction.entity.RiderPendingDepositDomain
import com.apnamart.apnarider.domain.rider_transaction.entity.StorePendingCashDomain

fun RiderCashDepositStoreLevelResponse.toRiderCashDepositStoreLevelDomain(): RiderCashDepositStoreLevelDomain {
    return RiderCashDepositStoreLevelDomain(
        totalPendingCash = totalCash ?: 0.0,
        storePendingCash = storeCashCollection?.map {
            it.toStorePendingCashDomain()
        } ?: emptyList()
    )
}

fun StoreCashCollectionResponse.toStorePendingCashDomain(): StorePendingCashDomain {
    return StorePendingCashDomain(
        totalCashAmount = totalCashAmount ?: 0.0,
        storeName = storeName.orEmpty(),
        storeId = storeId ?: 0,
        hour = hour.orEmpty(),
        approvedBy = approvedBy ?: emptyList()
    )
}

fun RiderPendingDepositResponse.toRiderPendingDepositDomain(): RiderPendingDepositDomain {
    return RiderPendingDepositDomain(
        month = month ?: "",
        storeName = storeName ?: "",
        deliveredAt = deliveredAt ?: "",
        cash = cash ?: 0.0,
        orderNumber = orderNumber ?: orderId ?: ""
    )
}

fun PayoutTotalDetailsResponse.toPayoutTotalDetailsModal(): PayoutTotalDetailsModal {
    return PayoutTotalDetailsModal(
        totalEarnings = totalEarnings?.toInt() ?: 0,
        totalOrderCount = totalOrderCount ?: 0,
        totalLoginHours = totalLoginHours ?: "",
    )
}


fun DateWiseDataResponse.toDateWiseDataModal(): DateWisePayoutDetailsDomain {
    return DateWisePayoutDetailsDomain(
        earnings = earnings ?: 0.0,
        orderCount = orderCount ?: 0,
        loginHours = loginHours ?: "",
        date = date ?: "",
        payoutBreakup = payoutBreakup?.map {
            it.toPayoutBreakdownModal()
        } ?: emptyList()

    )
}

fun PayoutBreakdownResponse.toPayoutBreakdownModal() : PayoutBreakdownDomain {
    return  PayoutBreakdownDomain (
        iconUrl = iconUrl.orEmpty(),
        payoutTypeId = payoutTypeId ?: 0,
        payoutTypeName = payoutTypeName.orEmpty(),
        value = value ?: 0.0
    )
}

fun RiderInHandCashDetailsResponse.toRiderInHandCashDetailsDomain(): RiderInHandCashDetailsDomain {
    return RiderInHandCashDetailsDomain(
        hasReachedLimit = cashCollectionLimitData?.hasReachedLimit ?: false,
        maxCashLimit = cashCollectionLimitData?.maxCashLimit ?: 0.0,
        pendingCash = cashCollectionLimitData?.pendingCash ?: 0.0,
        remainingLimit = cashCollectionLimitData?.remainingLimit ?: 0.0,
        cashCollectionLimitFlag = cashCollectionLimitFlag ?: false,
    )
}