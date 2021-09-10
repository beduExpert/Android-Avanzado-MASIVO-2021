package com.bedu.hilt.data.model

import com.squareup.moshi.Json

data class ResponsePeopleModel(
    @Json(name = "count")
    val count: Int = 0,
    @Json(name = "next")
    val next: String = "",
    @Json(name = "previous")
    val previous: String = "",
    @Json(name = "results")
    val results: List<People> = ArrayList()
)