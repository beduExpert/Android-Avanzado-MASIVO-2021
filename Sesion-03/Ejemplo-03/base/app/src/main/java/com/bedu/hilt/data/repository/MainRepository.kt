package com.bedu.hilt.data.repository

import com.bedu.hilt.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getPeople() =  apiHelper.getPeople()

}