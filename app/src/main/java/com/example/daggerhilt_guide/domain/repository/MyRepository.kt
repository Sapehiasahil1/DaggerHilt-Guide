package com.example.daggerhilt_guide.domain.repository

interface MyRepository {

    suspend fun doNetworkCall()
}