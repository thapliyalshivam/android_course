package com.example.tshivam.commun.pojo

import android.content.Context
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object Retro {
    lateinit var RETROFIT_CLIENT: gitApi

    fun get(): gitApi = RETROFIT_CLIENT

    fun setUpRetrofitClient(context: Context) {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
               // .client(fetchHeaders(context))
                .build()

        RETROFIT_CLIENT = retrofit.create(gitApi::class.java)
    }



}