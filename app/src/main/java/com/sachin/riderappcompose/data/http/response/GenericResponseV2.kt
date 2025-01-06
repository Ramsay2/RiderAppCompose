package com.apnamart.apnarider.data.http.response

import com.google.gson.annotations.SerializedName

class GenericResponseV2<out T>{

    @SerializedName("pagination")
    val paginationData: PaginationResponseV2? = null

    @SerializedName("message")
    val message: String? = null

    @SerializedName("error")
    val error: String? = null

    @SerializedName("code")
    val code: Int? = null

    @SerializedName("data")
    val data: T? = null

    @SerializedName("paginated_data")
    val paginatedData: T? = null

    @SerializedName("error_list")
    val errorList: List<ErrorList>? = null
}

data class ErrorList(
    @SerializedName("code")
    val errorCode: Int,
    @SerializedName("message")
    val errorMessage: String
)


data class PaginationResponseV2(
    @SerializedName("has_previous") val hasPrevious: Boolean,
    @SerializedName("has_next") val hasNext: Boolean,
    @SerializedName("page_size") val pageSize: Int,
    @SerializedName("current_page") val currentPage: Int,
)