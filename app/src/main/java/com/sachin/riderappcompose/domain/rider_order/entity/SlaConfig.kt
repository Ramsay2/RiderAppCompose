package com.apnamart.apnarider.data.http.response.rider_orders

import com.google.gson.annotations.SerializedName




data class SlaConfigResponse(
    @SerializedName("sla_config") val slaConfig : SlaConfig
){
    data class SlaConfig(
        @SerializedName("timer_states")val timerStates: List<TimerUIState>,
        @SerializedName("sla_packing")val slaPacking: TimingsResponse
    ){
        /**
         * returns the [TimerUIState] on the basis of [timeRemainingInMin] by checking that the [timeRemainingInMin] lies in rangeMin and rangeMax
         *
         * if [timeRemainingInMin] in negative its returns [DELAYED] timer state
         * if [timeRemainingInMin] is more it returns [NO_TIMER]
         */
        fun getUIState(timeRemainingInMin: Long?) : TimerUIState {
            return timerStates.find {
                (timeRemainingInMin ?: 0) > it.rangeMin && (timeRemainingInMin ?: 0) <= it.rangeMax
            } ?: kotlin.run { if ((timeRemainingInMin ?: 0) <= 0) timerStates[0] else timerStates[3]}
        }
    }
    data class TimerUIState(
        @SerializedName("state") val  state: TimerState,
        @SerializedName("text_color") private val textColor  : String,
        @SerializedName("card_color") private val cardColor : String,
        @SerializedName("range_min") val rangeMin : Int,
        @SerializedName("range_max") val  rangeMax: Int,

        ){
        fun getCardColor() : String{
            return when(state){
                TimerStates.DELAYED -> {
                    "#F5D9DE"
                }
                TimerStates.RUNNING_LATE -> {
                    "#FCF7DC"
                }
                TimerStates.ON_TIME, TimerStates.NO_TIMER -> {
                    "#EDFBE9"
                }
                else -> {
                    "#000"
                }
            }
        }

        fun getTextColor() : String{
            return when(state){
                TimerStates.DELAYED -> {
                    "#C41839"
                }
                TimerStates.RUNNING_LATE -> {
                    "#826C00"
                }
                TimerStates.ON_TIME, TimerStates.NO_TIMER -> {
                    "#196202"
                }
                else -> {
                    "#FFF"
                }
            }
        }
    }

    data class TimingsResponse(
        @SerializedName("timing")val slaPacking: Timing
    )

    data class Timing(
        @SerializedName("total_time")val totalTime: Int,
        @SerializedName("close_to_sla_time") val closeToSlaTime : Int
    )

    object TimerStates{
        const val DELAYED : TimerState = "DELAYED"
        const val RUNNING_LATE : TimerState = "RUNNING_LATE"
        const val ON_TIME : TimerState = "ON_TIME"
        const val NO_TIMER : TimerState = "NO_TIMER"
    }

}

typealias TimerState = String

