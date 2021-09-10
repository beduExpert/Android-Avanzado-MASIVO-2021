package com.bedu.hilt.data.api

import com.bedu.hilt.data.model.ResponsePeopleModel
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getPeople(): Response<ResponsePeopleModel> = apiService.getPeople()

}