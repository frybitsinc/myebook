package com.frybitsinc.myebook.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.frybitsinc.myebook.model.BookItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "BookFetcher"

class BookFetcher {
    private val bookApi: BookApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://openapi.naver.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        bookApi = retrofit.create(BookApi::class.java)
    }

    fun fetchBooks(): LiveData<List<BookItem>>{
        val responseLiveData: MutableLiveData<List<BookItem>> = MutableLiveData()
        val bookRequest: Call<BookResponse> = bookApi.fetchBooks()

        bookRequest.enqueue(object :Callback<BookResponse> {
            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                Log.e(TAG, "fetchBooks() FAILED", t)
                Log.e(TAG, "...................", t)
            }
            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                Log.d(TAG, "fetchBooks() SUCCEEDED")
                Log.d(TAG, "----------------------")
                val bookItems: List<BookItem> = response.body()?.bookItems?: mutableListOf()
                responseLiveData.value = bookItems
            }
        })
        return responseLiveData
    }
}