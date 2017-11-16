package com.myapplication

import com.google.gson.annotations.SerializedName

/**
 * Created by tedliang on 2017/11/16.
 */
data class DetailModel(
        @SerializedName("title") val title: String
)
