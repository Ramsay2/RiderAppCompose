package com.apnamart.apnarider.domain.rider_order

import com.apnamart.apnarider.core_app_framework.multithread.dispacher.DispatcherProvider
import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.domain._base.BaseHelperImplNew
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
import javax.inject.Inject

class RiderOrderHelperImpl @Inject
constructor(dataHelper: DataHelper, dispatcherProvider: DispatcherProvider) :
    BaseHelperImplNew(dataHelper, dispatcherProvider), RiderOrderHelper {
    override val getRiderOrdersUseCase: GetRiderOrdersUseCase
        get() = GetRiderOrdersUseCase(dataHelper, dispatcherProvider)
    override val getRiderOrderDetailUseCase: GetRiderOrderDetailUseCase
        get() = GetRiderOrderDetailUseCase(dataHelper, dispatcherProvider)
    override val updateOrderStatusUseCase: UpdateOrderStatusUseCase
        get() = UpdateOrderStatusUseCase(dataHelper, dispatcherProvider)

    override val updateRiderStatusUseCase: UpdateRiderStatusUseCase
        get() = UpdateRiderStatusUseCase(dataHelper, dispatcherProvider)
    override val verifyOnlineOrderReturn: VerifyOnlineOrderReturn
        get() = VerifyOnlineOrderReturn(dataHelper, dispatcherProvider)

    override val manuallyAssignRiderUseCase: ManuallyAssignRiderUseCase
        get() = ManuallyAssignRiderUseCase(dataHelper, dispatcherProvider)
    override val markRiderAtStoreUseCase: MarkRiderAtStoreUseCase
        get() = MarkRiderAtStoreUseCase(dataHelper, dispatcherProvider)
    override val getRiderDataUseCase: GetRiderDataUseCase
        get() = GetRiderDataUseCase(dataHelper, dispatcherProvider)

    override val getRiderOrdersSummaryUseCase: GetRiderOrdersSummaryUseCase
        get() = GetRiderOrdersSummaryUseCase(dataHelper, dispatcherProvider)
    override val getRiderCurrentStoreUseCase: GetRiderCurrentStoreUseCase
        get() = GetRiderCurrentStoreUseCase(dataHelper, dispatcherProvider)
    override val getRiderOrdersCountUseCase: GetRiderOrdersCountUseCase
        get() = GetRiderOrdersCountUseCase(dataHelper, dispatcherProvider)
    override val getRiderOrderListUseCaseV2: OrderListUseCaseV2
        get() = OrderListUseCaseV2(dataHelper, dispatcherProvider)
    override val verifyRiderAssignmentUseCase: VerifyRiderAssignmentUseCase
        get() = VerifyRiderAssignmentUseCase(dataHelper, dispatcherProvider)
    override val pickingTimerConfigUseCase: PickingTimerConfigUseCase
        get() = PickingTimerConfigUseCase(dataHelper)
    override val uploadOrderDeliveryImageUseCase: UploadOrderDeliveryImageUseCase
        get() = UploadOrderDeliveryImageUseCase(dataHelper, dispatcherProvider)
    override val deleteOrderDeliveryImageUseCase: DeleteOrderDeliveryImageUseCase
        get() = DeleteOrderDeliveryImageUseCase(dataHelper, dispatcherProvider)
    override val getOrderDeliveryImageUseCase: GetOrderDeliveryImageUseCase
        get() = GetOrderDeliveryImageUseCase(dataHelper, dispatcherProvider)

    override val subscribeOrdersUseCase: SubscribeOrdersUseCase
        get() = SubscribeOrdersUseCase(dataHelper, dispatcherProvider)
    override val unSubscribeOrdersUseCase: UnsubscribeOrdersUseCase
        get() = UnsubscribeOrdersUseCase(dataHelper, dispatcherProvider)
    override val disconnectMqttUseCase: DisconnectMqttUseCase
        get() = DisconnectMqttUseCase(dataHelper, dispatcherProvider)
}
