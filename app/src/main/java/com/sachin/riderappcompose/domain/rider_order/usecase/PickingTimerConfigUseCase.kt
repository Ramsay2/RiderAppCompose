package com.apnamart.apnarider.domain.rider_order.usecase

import com.apnamart.apnarider.data.DataHelper
import com.apnamart.apnarider.data.http.response.rider_orders.order_list_v2.PickingTimerConfigResponse
import com.apnamart.apnarider.domain.rider_order.entity.order_list_v2.PickingTimerConfigDomain
import com.apnamart.apnarider.domain.rider_order.mapper.toPickingTimerRemoteConfigDomain

class PickingTimerConfigUseCase(
    private val dataHelper: DataHelper
){



    fun onComplete(data : PickingTimerConfigResponse) : PickingTimerConfigDomain {
        return data.toPickingTimerRemoteConfigDomain()
    }

}