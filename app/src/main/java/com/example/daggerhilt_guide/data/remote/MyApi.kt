package com.example.daggerhilt_guide.data.remote

import retrofit2.http.GET

interface MyApi {

    @GET("test")
    suspend fun doNetworkCall()
}