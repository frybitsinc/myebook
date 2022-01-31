package com.frybitsinc.myebook.api

import com.frybitsinc.myebook.model.BookItem
import com.google.gson.annotations.SerializedName

class BookResponse {
    @SerializedName("items")
    lateinit var bookItems:List<BookItem>
}