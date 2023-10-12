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

/*
It is the module where we describe all the dependencies that hilt should automatically inject
when requested.
*/
@Module
/*
 The SingletonComponent here describes that the dependencies injected to different components of the
 applications such as activity etc. will live the lifespan of entire application, which means that when
 application will destroy the dependencies injected will destroy.

 Here we can use other classes such as
 ViewModelComponent => which let's the dependencies injected to live till the viewModel from where is is
 requested is not destroyed.
 */
@InstallIn(SingletonComponent::class)
object AppModule {

    /*
    So what basically happens behind the scenes is,
    whenever there is a request to inject the dependency, the dagger hilt comes into the module to check
    whether here there is any function that has the same return type as requested by the component for
    the particular constructor.
     */
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