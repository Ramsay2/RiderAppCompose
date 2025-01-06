package com.apnamart.apnarider.domain.consumer_auth.mapper

import com.apnamart.apnarider.core_app_framework.utility.datetime.DATE_FORMAT_ISO
import com.apnamart.apnarider.core_app_framework.utility.datetime.getDateFromFormattedString
import com.sachin.riderappcompose.data.cache.entities.UserCacheData
import com.apnamart.apnarider.data.http.response.consumer_auth.FranchiseeStoreResponse
import com.apnamart.apnarider.data.http.response.consumer_auth.UserData
import com.apnamart.apnarider.domain.consumer_auth.entity.FranchiseeStoreDomain

fun UserData.toUserCacheData(): UserCacheData {
    return UserCacheData(
        name = this.name,
        nickName = this.nickName,
        email = this.email,
        gender = this.gender,
        phone = this.phone,
        countryCode = this.countryCode,
        blocked = this.blocked,
        userId = this.userId,
        userImage = this.userImage,
        dob = this.dob,
        addedOn = getDateFromFormattedString(this.addedOn, DATE_FORMAT_ISO),
        isSuperuser = this.isSuperuser,
        isAreaManager = this.groups?.contains("area_manager") == true || this.isSuperuser,
        isStoreManager = this.groups?.contains("store_manager") == true || this.isSuperuser,
        isStoreOwner = this.groups?.contains("store_owner") == true || this.isSuperuser,
        isStoreStaff = this.groups?.contains("store_staff") == true || this.isSuperuser,
        isDeliveryAgent = this.groups?.contains("warehouse_delivery_boy") == true || this.isSuperuser,
        whatsapp = this.whatsapp,
        v3ModelEnable = this.riderData?.isV3Enabled ?: false,
        username = this.username
    )
}

fun FranchiseeStoreResponse.toFranchiseeStoreDomain(): FranchiseeStoreDomain {
    return FranchiseeStoreDomain(
        id,
        name,
        tagName,
        storeOpen,
        latitude?.toDoubleOrNull() ?: 0.0,
        longitude?.toDoubleOrNull() ?: 0.0,
        address,
        landmark,
        pinCode,
        city,
        state
    )
}
