package com.example.daggerhilt_guide.data.repository

import android.app.Application
import com.example.daggerhilt_guide.R
import com.example.daggerhilt_guide.data.remote.MyApi
import com.example.daggerhilt_guide.domain.repository.MyRepository
import javax.inject.Inject
/*
It is an implementation of the repository interface
It is done to increase the abstraction- hiding the implementation details
*/

class MyRepositoryImpl @Inject constructor( // Inject function is used to let hilt automatically inject
    // the dependencies.
    private val api : MyApi, // The dagger hilt will automatically get the instance of the MyApi module
    // from the Modules
    private val appContext : Application // The dagger hilt will automatically get the instance of the
    // Application from the Modules (where they are described)
) : MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }
    override suspend fun doNetworkCall() {

    }
}