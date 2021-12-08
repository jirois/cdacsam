package com.jinncyapps.authenapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

    private const val BASE_URL = "https://pure-fjord-77376.herokuapp.com/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    interface CdacsamApiService{
        @GET("api/clients")
        suspend fun getPropertites(): List<CdacsamPropery>
    }

    object CdacsamApi{

        val retrofitService: CdacsamApiService by lazy { retrofit.create(CdacsamApiService::class.java) }

    }

