package com.bedu.hilt.data.model

import com.squareup.moshi.Json

data class Planet(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "population")
    val population: String = "",
    @Json(name = "hair_color")
    val hairColor: String = "",
    @Json(name = "avatar")
    val avatar: String = ""
)