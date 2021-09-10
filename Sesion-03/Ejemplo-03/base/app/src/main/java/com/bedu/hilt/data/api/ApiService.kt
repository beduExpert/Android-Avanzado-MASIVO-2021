package com.bedu.hilt.data.api

import com.bedu.hilt.data.model.ResponsePeopleModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("people")
    suspend fun getPeople(): Response<ResponsePeopleModel>

}