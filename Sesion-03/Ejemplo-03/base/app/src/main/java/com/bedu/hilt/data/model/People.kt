package com.bedu.hilt.data.model

import com.squareup.moshi.Json


data class People(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "gender")
    val gender: String = "",
    @Json(name = "hair_color")
    val hairColor: String = "",
    @Json(name = "avatar")
    val avatar: String = ""
)