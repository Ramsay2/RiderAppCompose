package com.sachin.riderappcompose.data.cache.entities

import java.util.Date

data class UserCacheData(
    var name : String? = null,
    var nickName : String? = null,
    var email : String? = null,
    var gender : String? = null,
    var phone : String? = null,
    var countryCode : String? = null,
    var blocked : Boolean,
    var userId : Int,
    var userImage : String? = null,
    var whatsapp : String? = null,
    var dob : String? = null,
    var addedOn : Date? = null,
    var isStoreOwner: Boolean,
    var isStoreManager: Boolean,
    var isStoreStaff: Boolean,
    var isDeliveryAgent: Boolean,
    var isSuperuser: Boolean = false,
    var isAreaManager: Boolean = false,
    var v3ModelEnable : Boolean,
    var username: String? = null,
)
