package com.frybitsinc.myebook.api

import retrofit2.Call
import retrofit2.http.GET

interface BookApi {
    @GET("/v1/search/book_adv")
    fun fetchBooks(): Call<String>
}