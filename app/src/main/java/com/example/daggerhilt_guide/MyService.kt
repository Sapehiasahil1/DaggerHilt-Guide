package com.example.daggerhilt_guide

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.daggerhilt_guide.domain.repository.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// In service we cannot create the constructors, so inorder to inject the dependencies we
// used the method of

// FIELD Injection
@AndroidEntryPoint
class MyService : Service() {

    // Field Injection by creating a lateinit variable and setting it later using setter function.
    @Inject
    lateinit var repository: MyRepository

    override fun onCreate() {
        super.onCreate()


    }
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}