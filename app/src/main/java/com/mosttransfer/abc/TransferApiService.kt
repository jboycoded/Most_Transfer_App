package com.mosttransfer.abc

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.sofascore.com/api/v1/"

val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

// Create Retrofit object with Retrofit builder
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TransferApiService {
    @GET("transfer?page=1&sort=-transferDate")
    fun getTransfers():
            Call<Transfer>

    @GET("player/{playerId}/image")
    fun getPlayerImage(@Path("playerId") playerId: String):
            Call<String>
}

object TransferApi {
    val retrofitService: TransferApiService by lazy {
        retrofit.create(TransferApiService::class.java)
    }
}