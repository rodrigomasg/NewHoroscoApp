package com.horoscope.newhoroscoapp.data.network

import com.horoscope.newhoroscoapp.data.RepositoryImpl
import com.horoscope.newhoroscoapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://newastro.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): HoroscopeService {
        return retrofit.create(HoroscopeService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeService): Repository {
        return RepositoryImpl(apiService)
    }
}