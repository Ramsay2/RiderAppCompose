package com.apnamart.apnarider.domain.rider_order.entity.order_list

import com.apnamart.apnarider.domain.rider_order.entity.order_detail.ProductDomain
import java.util.Calendar
import java.util.Date

typealias DeliveryStatus = String

object DeliveryStatuses {
    const val RIDER_AUTO_ASSIGNED = "RAA"
    const val RIDER_REACHED_PICK_UP = "RCH_STR"
    const val RIDER_REACHED_DESTINATION = "RCH_DEST"
    const val RIDER_RETURNING_TO_STORE = "RTRN_TO_STR"

    const val DEL_CREATED = "CRT"
    const val RIDER_ASSIGNED = "ASGN"
    const val DEL_PICK_UP_VERIFIED = "PK_UP_VRF"
    const val DEL_DISPATCH = "DIS"
    const val DEL_DELIVERED = "DEL"
    const val DEL_ORDER_UPDATED = "ORD_UPDT"
    const val DEL_RETURN_VERIFIED = "RTRN_VRF"
    const val DEL_CANCELLED = "CAN"
    const val PAYMENT_RECEIVED = "PMNT_RCD"
    const val HANDOVER_ORDER = "HND_ODR"
}

data class AllocatedOrdersDomain(
    val id: Int,
    val billId: Int,
    val orderNumber: String,
    val eta: Date,
    var deliveryStatus: DeliveryStatus,
    val statusTag: String,
    val status: String,
    val billNumber: String,
    val otp: String,
    val amount: Double,
    val customerName: String,
    val customerAddress: String,
    val customerPhone: String,
    val storeName: String,
    val storeAddress: String,
    val storeLat: Double,
    val storeLng: Double,
    val customerLat: Double,
    val customerLng: Double,
    val paymentMethod: String,
    val paymentTag: String,
    val orderedAt: Date,
    val storeCity: String,
    val customerCity: String,
    val isV3ModelEnabled: Boolean,
    val isCashCollectionEnabled: Boolean,
    val storeId: Int,
    val paymentStatusTag: String,
    val txnId : String?,
    var reachedDestinationRadius: Double,
    var products: List<ProductDomain>?,
    var takePhotoOnDelivery: Boolean
) {
    fun isOrderPickupDelayed(outForDeliveryTime: Long): Boolean {
        if (isOrderPacked()) {
            return Calendar.getInstance().time.time > eta.time - outForDeliveryTime && eta.day == Calendar.getInstance().time.day
        }
        return false
    }

    fun isDeliveryDelayed(): Boolean {
        if (isOrderDispatched() || isOrderPacked()) {
            return Calendar.getInstance().time.time > eta.time && eta.day == Calendar.getInstance().time.day
        }
        return false
    }

    private fun isOrderPacked(): Boolean {
        return statusTag == "PKD"
    }

    private fun isOrderDispatched(): Boolean {
        return statusTag == "DIS"
    }
}

data class OrderTimingsDomain(
    val eta: Date,
    val orderAt: Date,
    val updatedAt: Date,
    val deliveredAt: Date,
    val packedAt: Date
)

