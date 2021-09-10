package com.bedu.hilt.data.api

import com.bedu.hilt.data.model.ResponsePeopleModel
import com.bedu.hilt.data.model.ResponsePlanetModel
import retrofit2.Response

interface ApiHelper {

    suspend fun getPeople(): Response<ResponsePeopleModel>

    suspend fun getPlanets(): Response<ResponsePlanetModel>
}