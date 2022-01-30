package com.frybitsinc.myebook.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface BookApi {
    @Headers(
        "X-Naver-Client-Id: 4PlWWzVp448z2YrYDa3S",
        "X-Naver-Client-Secret: GR0rkuQsTQ",
    )
    @GET("/v1/search/book.json?"+
            "sort=date"+
            "&query=안드로이드")
    fun fetchBooks(): Call<String>
}