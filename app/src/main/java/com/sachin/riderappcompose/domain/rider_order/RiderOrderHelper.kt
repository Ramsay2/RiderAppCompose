package com.apnamart.apnarider.domain.rider_order

import com.apnamart.apnarider.domain.rider_order.usecase.DeleteOrderDeliveryImageUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.DisconnectMqttUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.GetOrderDeliveryImageUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.GetRiderCurrentStoreUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.GetRiderDataUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.GetRiderOrderDetailUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.GetRiderOrdersCountUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.GetRiderOrdersSummaryUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.GetRiderOrdersUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.ManuallyAssignRiderUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.MarkRiderAtStoreUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.OrderListUseCaseV2
import com.apnamart.apnarider.domain.rider_order.usecase.PickingTimerConfigUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.SubscribeOrdersUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.UnsubscribeOrdersUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.UpdateOrderStatusUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.UpdateRiderStatusUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.UploadOrderDeliveryImageUseCase
import com.apnamart.apnarider.domain.rider_order.usecase.VerifyOnlineOrderReturn
import com.apnamart.apnarider.domain.rider_order.usecase.VerifyRiderAssignmentUseCase

interface RiderOrderHelper {
    val getRiderOrdersUseCase: GetRiderOrdersUseCase
    val getRiderOrderDetailUseCase: GetRiderOrderDetailUseCase
    val updateOrderStatusUseCase: UpdateOrderStatusUseCase
    val updateRiderStatusUseCase: UpdateRiderStatusUseCase
    val verifyOnlineOrderReturn : VerifyOnlineOrderReturn
    val manuallyAssignRiderUseCase : ManuallyAssignRiderUseCase
    val markRiderAtStoreUseCase : MarkRiderAtStoreUseCase
    val getRiderDataUseCase : GetRiderDataUseCase
    val getRiderOrdersSummaryUseCase : GetRiderOrdersSummaryUseCase
    val getRiderCurrentStoreUseCase : GetRiderCurrentStoreUseCase
    val getRiderOrdersCountUseCase : GetRiderOrdersCountUseCase
    val getRiderOrderListUseCaseV2 : OrderListUseCaseV2
    val verifyRiderAssignmentUseCase :VerifyRiderAssignmentUseCase
    val pickingTimerConfigUseCase : PickingTimerConfigUseCase
    val uploadOrderDeliveryImageUseCase: UploadOrderDeliveryImageUseCase
    val deleteOrderDeliveryImageUseCase: DeleteOrderDeliveryImageUseCase
    val getOrderDeliveryImageUseCase: GetOrderDeliveryImageUseCase
    val subscribeOrdersUseCase: SubscribeOrdersUseCase
    val unSubscribeOrdersUseCase: UnsubscribeOrdersUseCase
    val disconnectMqttUseCase: DisconnectMqttUseCase
}