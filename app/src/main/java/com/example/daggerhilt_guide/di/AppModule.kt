package com.example.daggerhilt_guide.di

import android.app.Application
import com.example.daggerhilt_guide.data.remote.MyApi
import com.example.daggerhilt_guide.data.repository.MyRepositoryImpl
import com.example.daggerhilt_guide.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // It tells the lifetime of the App Module
object AppModule {

    @Provides
    @Singleton // It tells the Scope.
    fun provideMyApi(): MyApi {

        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(
        api: MyApi,
        app: Application,
        @Named("hello 1") hello: String
    ): MyRepository {
        return MyRepositoryImpl(api, app)
    }

    @Provides
    @Singleton
    @Named("hello 1")
    fun provideString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello 2")
    fun provideString2() = "Hello 2"

}