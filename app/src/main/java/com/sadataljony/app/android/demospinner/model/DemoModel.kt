package com.sadataljony.app.android.demospinner.model

import com.google.gson.annotations.SerializedName

data class DemoModel(
    @SerializedName("productOwnerName") val productOwnerName: String,
    @SerializedName("productOwnersPin") val productOwnersPin: Int,
    @SerializedName("appCode") val appCode: String,
    @SerializedName("isOwner") val isOwner: Boolean
) {
    override fun toString(): String {
        return "$productOwnerName , $productOwnersPin"
    }
}