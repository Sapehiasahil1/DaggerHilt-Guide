package com.example.daggerhilt_guide.data.remote

import retrofit2.http.GET

interface MyApi {

    // It is an interface that we create to write all the requests that we want to request from the server API.
    @GET("test")
    suspend fun doNetworkCall()
}