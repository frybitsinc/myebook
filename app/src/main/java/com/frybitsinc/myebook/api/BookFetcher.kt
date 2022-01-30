package com.frybitsinc.myebook.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "BookFetcher"

class BookFetcher {
    private val bookApi: BookApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://openapi.naver.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
        bookApi = retrofit.create(BookApi::class.java)
    }

    fun fetchBooks(): LiveData<String>{
        val responseLiveData: MutableLiveData<String> = MutableLiveData()
        val bookRequest: Call<String> = bookApi.fetchBooks()

        bookRequest.enqueue(object :Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "fetchBooks() FAILED", t)
                Log.e(TAG, "...................", t)
            }
            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d(TAG, "fetchBooks() SUCCEEDED")
                Log.d(TAG, "----------------------")
                Log.d(TAG, "${response.body()}")
                responseLiveData.value = response.body()
            }
        })
        return responseLiveData
    }
}