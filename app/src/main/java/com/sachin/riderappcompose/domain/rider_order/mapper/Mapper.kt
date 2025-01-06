package com.apnamart.apnarider.domain.rider_order.mapper

import com.apnamart.apnarider.core_app_framework.utility.datetime.DATE_FORMAT_ISO
import com.apnamart.apnarider.core_app_framework.utility.datetime.getDateFromFormattedString
import com.apnamart.apnarider.data.http.response.rider_orders.DataResponse
import com.apnamart.apnarider.data.http.response.rider_orders.RiderDataResponse
import com.apnamart.apnarider.data.http.response.rider_orders.StoreDataResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.DeliveryAddressDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.DeliveryDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.GetOrderDeliveryImageListResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.InstructionsResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.OrderCountResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.OrderSummaryResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.PaymentDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.PickupAddressDetailsResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.ProductResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.RiderOrderDetailResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_detail.UploadOrderDeliveryImageResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_list.AllocatedOrdersResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_list.OrderTimingResponse
import com.apnamart.apnarider.data.http.response.rider_orders.order_list_v2.OrderResponseV2
import com.apnamart.apnarider.data.http.response.rider_orders.order_list_v2.OrdersListResponseV2
import com.apnamart.apnarider.data.http.response.rider_orders.order_list_v2.PickingTimerConfigResponse
import com.apnamart.apnarider.data.http.response.rider_orders.orders_count.RiderOrdersCountResponse
import com.apnamart.apnarider.data.http.response.store_details.CurrentStoreDetailsResponse
import com.apnamart.apnarider.data.http.response.verify_rider_assignment.VerifyRiderAssignmentResponseV2
import com.apnamart.apnarider.data.mqtt.response.PendingOrderResponse
import com.apnamart.apnarider.domain.rider_order.entity.RiderDataDomain
import com.apnamart.apnarider.domain.rider_order.entity.RiderDetailsDomain
import com.apnamart.apnarider.domain.rider_order.entity.StoreDataDomain
import com.apnamart.apnarider.domain.rider_order.entity.mqtt.PendingOrderDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.DeliveryAddressDetailsDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.DeliveryDetailsDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.GetOrderDeliveryImageListDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.InstructionsDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.OnlineOrderSummaryDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.OrderCountDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.OrderDeliveryImageDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.PaymentDetailsDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.PickupAddressDetailsDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.ProductDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_detail.RiderOrderDetailDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_list.AllocatedOrdersDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_list.OrderTimingsDomain
import com.apnamart.apnarider.domain.rider_order.entity.order_list_v2.OrderDomainV2
import com.apnamart.apnarider.domain.rider_order.entity.order_list_v2.OrderListDomainV2
import com.apnamart.apnarider.domain.rider_order.entity.order_list_v2.PickingTimerConfigDomain
import com.apnamart.apnarider.domain.rider_order.entity.orders_count.RiderOrdersCountDomain
import com.apnamart.apnarider.domain.rider_order.entity.store_details.GetCurrentStoreDetailsDomain
import com.apnamart.apnarider.domain.rider_order.entity.verify_rider_assignment.VerifyRiderAssignmentDomainV2
import com.sachin.riderappcompose.data.cache.entities.CurrentStoreCache
import com.sachin.riderappcompose.data.cache.entities.PendingOrderCache
import java.util.Date


fun AllocatedOrdersResponse.toAllocatedOrdersDomain(): AllocatedOrdersDomain {
    return AllocatedOrdersDomain(
        id = orderDetails?.id ?: 0,
        billId = orderDetails?.billId ?: 0,
        orderNumber = orderDetails?.orderNumber ?: "",
        deliveryStatus = orderDetails?.deliveryStatus ?: "",
        eta = getDateFromFormattedString(orderDetails?.eta, DATE_FORMAT_ISO) ?: Date(),
        status = orderDetails?.status ?: "",
        statusTag = orderDetails?.statusTag ?: "",
        billNumber = orderDetails?.billNo ?: "Not Generated",
        otp = orderDetails?.otp ?: "",
        amount = orderDetails?.amount ?: 0.0,
        customerName = customerDetails?.name ?: "",
        customerAddress = customerDetails?.address ?: "",
        customerPhone = customerDetails?.phone ?: "",
        storeName = storeDetails?.name ?: "",
        storeAddress = storeDetails?.address ?: "",
        storeLat = storeDetails?.latitude ?: 0.0,
        storeLng = storeDetails?.longitude ?: 0.0,
        customerLat = customerDetails?.latitude ?: 0.0,
        customerLng = customerDetails?.longitude ?: 0.0,
        paymentMethod = orderDetails?.paymentMethod ?: "",
        paymentTag = orderDetails?.paymentTag ?: "",
        orderedAt = getDateFromFormattedString(orderDetails?.orderAt, DATE_FORMAT_ISO) ?: Date(),
        storeCity = orderDetails?.city ?: "",
        customerCity = customerDetails?.customerCity?: "",
        isCashCollectionEnabled = storeDetails?.riderCashCollection ?: false,
        isV3ModelEnabled = orderDetails?.isV3ModelEnabled ?: false,
        storeId = storeDetails?.id ?: 0,
        paymentStatusTag = orderDetails?.paymentStatusTag ?: "",
        txnId = orderDetails?.txnId,
        reachedDestinationRadius = orderDetails?.reachedDestinationRadius ?: 2.0,
        products = productDetails?.map { it.toProductDomain() },
        takePhotoOnDelivery = orderDetails?.takePhotoOnDelivery ?: false
    )
}

fun OrderTimingResponse.toOrderTimingsDomain(): OrderTimingsDomain {
    return OrderTimingsDomain(
        eta = getDateFromFormattedString(eta, DATE_FORMAT_ISO) ?: Date(),
        orderAt = getDateFromFormattedString(orderAt, DATE_FORMAT_ISO) ?: Date(),
        updatedAt = getDateFromFormattedString(updatedAt, DATE_FORMAT_ISO) ?: Date(),
        deliveredAt = getDateFromFormattedString(deliveredAt, DATE_FORMAT_ISO) ?: Date(),
        packedAt = getDateFromFormattedString(packedAt, DATE_FORMAT_ISO) ?: Date(),
    )
}


fun RiderOrderDetailResponse.toRiderOrderDetailDomain(): RiderOrderDetailDomain {
    return RiderOrderDetailDomain(
        deliveredIn,
        id,
        orderId,
        orderNumber,
        profile,
        customerPhone,
        customerName,
        statusTag,
        delTag,
        status,
        delStatus,
        deliveryAddressDetails?.toDeliveryAddressDetailDomain(),
        paymentDetails?.toPaymentDetailsDomain(),
        pickupAddressDetails?.toPickupAddressDetailsDomain(),
        orderTimings?.toOrderTimingsDomain(),
        instructions?.toInstructionsDomain(),
        deliveryDetails?.toDeliveryDetailsDomain()
    )
}


fun DeliveryAddressDetailsResponse.toDeliveryAddressDetailDomain(): DeliveryAddressDetailsDomain {
    return DeliveryAddressDetailsDomain(
        addressName,
        state,
        city,
        phone,
        pinCode,
        latitude?.toDoubleOrNull() ?: 0.0,
        longitude?.toDoubleOrNull() ?: 0.0,
        landmark, userAddress, fullAddress, otherAddressDetails, contactPerson, country, countryCode
    )
}


fun PaymentDetailsResponse.toPaymentDetailsDomain(): PaymentDetailsDomain {
    return PaymentDetailsDomain(
        orderAmount = orderAmount,
        totalAmount = totalAmount,
        deliveryCharges = deliveryCharges,
        savings = savings,
        name = name,
        tagName = tagName,
        billedAmount = billedAmount ?: 0.0
    )
}

fun PickupAddressDetailsResponse.toPickupAddressDetailsDomain(): PickupAddressDetailsDomain {
    return PickupAddressDetailsDomain(
        storeId ?: 0,
        storeName,
        storeTag,
        latitude?.toDoubleOrNull() ?: 0.0,
        longitude?.toDoubleOrNull() ?: 0.0,
        address, city, pinCode
    )
}

fun InstructionsResponse.toInstructionsDomain(): InstructionsDomain {
    return InstructionsDomain(deliveryInstructions, remarks)
}


fun DeliveryDetailsResponse.toDeliveryDetailsDomain(): DeliveryDetailsDomain {
    return DeliveryDetailsDomain(
        mode, pickUp, homeDelivery, slugName, id
    )
}

fun DataResponse.toRiderDetailsDomain(): RiderDetailsDomain {
    return RiderDetailsDomain(
        riderData = riderData?.toRiderDataDomain(),
        storeData = storeData?.toStoreDataDomain(),
        isStoreAllocated = isStoreAllocated ?: false
    )
}

fun StoreDataResponse.toStoreDataDomain(): StoreDataDomain {
    return StoreDataDomain(
        pendingOrderCount = pendingOrderCount ?: 0,
        storeLatitude = storeLatitude?.toDouble() ?: 0.0,
        storeLongitude = storeLongitude?.toDouble() ?: 0.0
    )
}

fun RiderDataResponse.toRiderDataDomain(): RiderDataDomain {
    return RiderDataDomain(
        deliveryRadius = deliveryRadius ?: 0.0,
        markInRadius = markInRadius ?: 0.0,
        markedIn = markedIn ?: false,
        pickUpRadius = pickUpRadius ?: 0.0,
        reachedStore = reachedStore ?: false,
        status = status ?: "",
        username = username ?: "",
        workingHours = workingHours ?: 0
    )
}


fun OrderSummaryResponse.toOnlineOrderSummaryDomain(): OnlineOrderSummaryDomain {
    return OnlineOrderSummaryDomain(
        handoverBreached = handoverBreached,
        orderCount = orderCount?.toOrderCountDomain(),
        pickingBreached = pickingBreached,
        deliveryBreached = deliveryBreached
    )
}

fun OrderCountResponse.toOrderCountDomain(): OrderCountDomain {
    return OrderCountDomain(
        confirmedCount = confirmedCount,
        packedCount = packedCount,
        placedCount = placedCount
    )
}

fun CurrentStoreDetailsResponse.getCurrentStoreDetailsDomain() : GetCurrentStoreDetailsDomain {
    return GetCurrentStoreDetailsDomain(
        storeId = storeId ?: 0,
        name = name ?: "",
        riderAutoAssignment = riderAutoAssignment ?: false,
        latitude = latitude ?: 0.0,
        longitude = longitude ?: 0.0,
        radius = radius ?: 0f,
        markOutThreshold = markOutThreshold ?: 0f,
        address = address ?: "",
        geofenceMarkOutEnabled = geofenceMarkOutEnabled ?: false
    )
}

fun GetCurrentStoreDetailsDomain.toCurrentStoreCache() : CurrentStoreCache {
    return CurrentStoreCache(
        storeId = storeId,
        name = name,
        riderAutoAssignment = riderAutoAssignment,
        latitude = latitude,
        longitude = longitude,
        radius = radius,
        markOutThreshold = markOutThreshold,
        address = address,
        geofenceMarkOutEnabled = geofenceMarkOutEnabled
    )
}

fun RiderOrdersCountResponse.toRiderOrdersCount() : RiderOrdersCountDomain {
    return RiderOrdersCountDomain(
        confirmOrderCount = confirmOrderCount ?: 0,
        pendingOrderCount = pendingOrderCount ?: 0,
        pendingReturnOrderCount = pendingReturnOrderCount ?: 0
    )
}

fun OrdersListResponseV2.toOrderListDomainV2() : OrderListDomainV2{

    return OrderListDomainV2(
        orderListV2 = orders?.map { it.toOrderDomainV2() } ?: emptyList()
    )

}
 fun OrderResponseV2.toOrderDomainV2() : OrderDomainV2{
     return OrderDomainV2(
         orderId = orderId ?: -1,
         customerName = customerName ?: "",
         customerAddress = customerAddress ?: "",
         noOfItems = noOfItems ?: -1,
         billId = billId ?: -1,
         billNo = billNo ?: "",
         heading = heading ?: "",
         subHeading = subHeading ?: "",
         deliveryModeString = deliveryModeString ?: "",
         deliveryStatus = deliveryStatus ?: "",
         deliveryStatusTag = deliveryStatusTag ?: "",
         isRush = isRush ?: false,
         orderStatus = orderStatus ?: "",
         orderStatusTag = orderStatusTag ?: "",
         showCustomerAddress = showCustomerAddress ?: false
     )
 }

fun VerifyRiderAssignmentResponseV2.toVerifyRiderAssignmentDomainV2() : VerifyRiderAssignmentDomainV2
{
    return VerifyRiderAssignmentDomainV2(
        checkNeeded = checkNeeded ?: false
    )
}

fun PickingTimerConfigResponse.toPickingTimerRemoteConfigDomain() : PickingTimerConfigDomain {
    return PickingTimerConfigDomain(
        enable = enable ?: false,
        pickingTime = pickingTime ?: 5,
        cardTextColor = cardTextColor ?: "#FF1515",
        cardColorBackground = cardColorBackground ?: "#FF837B"
    )
}

fun UploadOrderDeliveryImageResponse.toUploadDeliveryImageDomain(): OrderDeliveryImageDomain {
    return OrderDeliveryImageDomain(
        id = id ?: 0,
        url = url ?: ""
    )
}

fun GetOrderDeliveryImageListResponse.toGetOrderDeliveryImageListDomain(): GetOrderDeliveryImageListDomain {
    return GetOrderDeliveryImageListDomain(
        imageList = imageList?.map { it.toUploadDeliveryImageDomain() }
    )
}

fun ProductResponse.toProductDomain(): ProductDomain {
    return ProductDomain(
        productId = productId ,
        mainImage = mainImage,
        displayName = displayName,
        isHighValueItem = isHighValueItem
    )
}

fun PendingOrderResponse.toPendingOrderDomain(): PendingOrderDomain {
    return PendingOrderDomain(
        id, orderId, statusTag, delStatusTag, deliveryAgent, delMode ?: "rush",
        storeOpenTime ?: "10:00:00",
        closeTime ?: "20:00:00",
        getDateFromFormattedString(orderAt, DATE_FORMAT_ISO),
        getDateFromFormattedString(eta, DATE_FORMAT_ISO)
    )
}

fun PendingOrderDomain.toPendingOrderCache(): PendingOrderCache {
    return PendingOrderCache(
        id,
        orderId,
        statusTag,
        delStatusTag,
        deliveryAgent,
        delMode,
        storeOpenTime,
        closeTime,
        orderAt,
        eta
    )
}

fun PendingOrderCache.toPendingOrderDomain(): PendingOrderDomain {
    return PendingOrderDomain(
        id,
        orderId,
        statusTag,
        delStatusTag,
        deliveryAgent,
        delMode,
        storeOpenTime ?: "",
        closeTime ?: "",
        orderAt,
        eta
    )
}