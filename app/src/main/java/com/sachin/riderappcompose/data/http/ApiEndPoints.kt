package com.apnamart.apnarider.data.http


const val BASE_URL = "https://smapi-dev.apnamart.in"
const val TEZ_BASE_URL = "https://tezapi-dev.apnamart.in"

/* User Related */

// OTP
const val SEND_OTP = "api/profile/send_phone_otp/"
const val VERIFY_OTP = "api/profile/verify_otp/"

// FCM
const val CREATE_FCM = "api/profile/create_fcm/"

// Get and update user data
const val GET_USER_DATA = "api/profile/get_user_data/"
const val UPDATE_PROFILE = "api/profile/update_profile/{userId}/"

// Logout
const val LOGOUT = "api/profile/logout/"

/* App Related */
const val CHECK_APP_UPDATE = "api/app/check_app_version/"
const val GET_OPERATED_STORES = "api/store/get_rider_stores/"

const val GET_RIDER_ORDER_LIST = "api/rider/list_rider_orders/"
const val UPDATE_ORDER_STATUS = "api/app/update_order_status/v3/"
const val UPDATE_ORDER_RIDER_STATUS = "/api/app/update_order_rider_status/{order_id}/"
const val GET_RIDER_ORDER_DETAILS = "api/rider/get_rider_order_details/{order_id}/"
const val VERIFY_RETURN = "api/app/authenticate_verification_code/"
const val GET_ONLINE_ORDER_SUMMARY = "api/app/store_online_order_summary/"


const val MARK_IN_RIDER = "api/rider/mark_in_rider/v2/"
const val GET_RIDER_MARK_IN_STATUS = "api/rider/get_rider_mark_in_status/"
const val MARK_OUT_RIDER = "api/rider/mark_out_rider/v2/"

const val SCAN_ORDER = "api/rider/scan_order/"
const val MARK_RIDER_AT_STORE = "api/rider/mark_rider_at_store/"
const val GET_RIDER_DATA = "api/rider/get_rider_data/"

const val  CREATE_PAYMENT_DQR = "api/payments/payu_transaction_request/"
const val  GET_PAYMENT_STATUS = "/api/payments/get_payment_status/"
const val  CANCEL_DQR = "/api/payments/cancel_transaction/"
const val GET_PAYMENT_MODE = "/api/payments/get_store_payment_modes/{storeId}/"
const val GET_CURRENT_RIDER_STORE = "/api/rider/get_current_rider_store/"

const val GET_RIDER_ORDERS_COUNT = "/api/rider/get_rider_order_count/"

const val LIST_RIDER_ORDERS_V2 = "/api/rider/list_rider_orders_v2/"

const val VERIFY_RIDER_ASSIGNMENT = "/api/rider/verify_rider_assignment/"

const val UPLOAD_ORDER_DELIVERY_IMAGE = "/api/order/upload_order_delivery_image/{order_id}/"
const val DELETE_ORDER_DELIVERY_IMAGE = "/api/order/delete_order_delivery_image/{image_id}/"
const val GET_ORDER_DELIVERY_IMAGE = "/api/order/get_order_delivery_images/{order_id}/"
const val VALIDATE_RIDER_AT_STORE = "/api/rider/validate_rider_at_store/"


const val GET_RIDER_STORE_COLLECTION = "api/rider/get_rider_store_collection/"
const val GET_PAGINATED_RIDER_PENDING_CASH = "api/rider/get_paginated_rider_collection/"

const val GET_CITIES = "/api/rider/list_rider_cities/"

//Create and Update onboarding data
const val CREATE_UPDATE_ONBOARDING_DATA = "/api/profile/create_or_update_kyc_onboarding_application/"

//Rider payout
const val GET_RIDER_PAYOUT_DETAILS = "/api/rider/get_rider_payout_details/"
const val GET_RIDER_PAYOUT_TOTAL = "/api/rider/get_rider_payout_total/"

//KYC
const val GET_KYC_DETAILS  = "api/profile/get_user_kyc_details/"

const val GET_RIDER_IN_HAND_CASH_DETAILS = "api/rider/get_rider_inhand_cash_details"
