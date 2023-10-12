package com.example.daggerhilt_guide

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// It is used to provide the instance of the application, as we cannot directly get the instance it.
@HiltAndroidApp
class MyApp : Application()