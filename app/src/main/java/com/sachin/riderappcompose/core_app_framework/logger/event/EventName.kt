package com.apnamart.apnarider.core_app_framework.logger.event


object EventName {
    const val MARKED_IN = "marked_in"
    const val MARKED_OUT = "marked_out"
    const val SCREEN_VIEW = "screen_view"
    const val UPDATED_PROFILE = "updated_profile"

    const val ORDER_PICKED_UP = "order_picked_up"
    const val CALL_CUSTOMER_SUPPORT_CLICKED = "call_customer_support_clicked"
    const val WHATSAPP_CUSTOMER_SUPPORT = "whatsapp_customer_support"

    const val BATTERY_OPTIMIZATION_PERMISSION = "battery_optimization_permission"
    const val OVERLAY_PERMISSION = "overlay_permission"
    const val API_ERROR = "api_error"
    const val REACHED_STORE = "reached_Store"
    const val COLLECT_PAYMENT_CLICKED = "collect_payment_clicked"
    const val COLLECT_CASH_CLICKED = "collect_cash_clicked"
    const val GENERATE_QR_CLICKED = "generate_qr_clicked"
    const val REGENERATE_QR_CLICKED = "regenerate_qr_clicked"
    const val MQTT_CONNECTED = "mqtt_connected"
    const val MQTT_CONNECTION_FAILED = "mqtt_connection_failed"
    const val MQTT_SUBSCRIPTION_FAILED = "mqtt_subscription_failed"
    const val MQTT_SUBSCRIBED= "mqtt_subscribed"
    const val MQTT_MESSAGE_RECEIVED = "mqtt_message_received"
    const val REACHED_DESTINATION = "reached_destination"
    const val COMPLETE_DELIVERY = "complete_delivery"
    const val HAND_OVER = "hand_over"
    const val CANCEL_PAYMENT_CLICKED = "cancel_payment_clicked"
    const val GEOFENCE_ADDED = "geofence_added"
    const val GEOFENCE_FAILED = "geofence_added"
    const val GEOFENCE_TRIGGERED = "geofence_triggered"
    const val GEOFENCE_NOT_TRIGGERED = "geofence_not_triggered"
    const val LOCATION_PERMISSION = "location_permission"
    const val GEOFENCE_INCORRECT_DATA = "geofence_incorrect_data"

    const val BUZZER_ELIGIBLE_ORDERS = "buzzer_eligible_orders"
    const val ALARM_RING_SCREEN = "alarm_ring_screen"
    const val ALARM_RING_SCREEN_DISMISS_CLICKED = "alarm_ring_screen_dismiss_clicked"
    const val HAND_OVER_CX = "hand_over_cx"

    //Signup-Login flow
    const val APP_SIGNUP_MOBILE_HINT_SELECTED = "app_signup_mobile_hint_selected"
    const val PHONE_NUMBER_INPUT_CLICKED = "phone_number_input_clicked"
    const val APP_SIGNUP_PHONE_NUMBER_TYPE_STARTED = "app_signup_phone_number_type_started"
    const val APP_SIGNUP_PHONE_NUMBER_TYPED = "app_signup_phone_number_typed"
    const val OTP_TYPED = "otp_typed"
    const val APP_SIGNUP_MOBILE_HINT_FIRED = "app_signup_mobile_hint_fired"
    const val APP_SIGNUP_MOBILE_HINT_EMPTY = "app_signup_mobile_hint_empty"
    const val OTP_NOT_SENT = "otp_not_sent"
    const val SIGNUP_PHONE_NUMBER_EDITED = "signup_phone_number_edited"
    const val SIGNUP_PHONE_NUMBER_EDIT_CLICKED = "signup_phone_number_edit_clicked"
    const val OTP_SENT = "otp_sent"
    const val CONTINUE_IN_SIGNUP_CLICKED = "continue_in_signup_clicked"
    const val OTP_INITIATED = "otp_initiated"
    const val RESEND_OTP_CLICKED = "resend_otp_clicked"
    const val VERIFYING_OTP = "verifying_otp"
    const val INTERNET_CONNECTION = "internet_connection"

    //Logout events
    const val LOGOUT_CLICKED = "logout_clicked"
}