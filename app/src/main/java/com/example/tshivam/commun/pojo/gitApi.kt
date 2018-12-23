package com.example.tshivam.commun.pojo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface gitApi {

    @GET("search/users")
fun apiGetUsers(@Query("q")query:String):Call<ApiResponse>
}