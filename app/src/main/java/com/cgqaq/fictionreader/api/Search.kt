package com.cgqaq.fictionreader.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Search {
    @GET("/novel/search")
    fun search(@Query("q") query: String): Call<String>
}