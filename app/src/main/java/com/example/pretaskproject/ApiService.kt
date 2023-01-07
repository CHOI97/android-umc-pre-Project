package com.example.pretaskproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {

    @GET("${BuildConfig.ENDPOINT_GET_BOOKSTORE_LOC}")
    fun getBookstoreInfo(
        @Header("accept") token : String,
        //보낼 정보
        @Query("serviceKey") serviceKey : String,
        @Query("numOfRows") numOfRows : String,
        @Query("pageNo") pageNo : String
    ): Call<Response>
}