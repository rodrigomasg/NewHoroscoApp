package com.horoscope.newhoroscoapp.data.network

import com.horocope.newhoroscoapp.BuildConfig.BASE_URL
import com.horoscope.newhoroscoapp.data.RepositoryImpl
import com.horoscope.newhoroscoapp.data.core.interceptor.AuthInterceptor
import com.horoscope.newhoroscoapp.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkkHttpClient(authInter: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInter)
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