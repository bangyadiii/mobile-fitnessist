package com.capstone_bangkit.fitnessist.api


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

@Keep
data class PaginationData<T>(
    @SerializedName("current_page")
    @Expose
    val currentPage: Int?,
    @SerializedName("items")
    @Expose
    val items: List<T>?,

    @SerializedName("links")
    @Expose
    val links: LinksPagination?,

    @SerializedName("per_page")
    @Expose
    val perPage: Int?,

    @SerializedName("total_items")
    @Expose
    val totalItems: String?,

    @SerializedName("total_pages")
    @Expose
    val totalPages: Int?
)