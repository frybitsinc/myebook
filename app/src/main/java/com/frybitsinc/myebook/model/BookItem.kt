package com.frybitsinc.myebook.model

import com.google.gson.annotations.SerializedName

data class BookItem(
        @SerializedName("title")
        var title: String = "",
        @SerializedName("link")
        var link: String = "",
        @SerializedName("image")
        var image: String = "",
        @SerializedName("author")
        var author: String = "",
        @SerializedName("price")
        var price: String = "",
        @SerializedName("publisher")
        var publisher: String = "",
        @SerializedName("pubdate")
        var pubdate: String = "",
        @SerializedName("isbn")
        var isbn: String = "",
        @SerializedName("description")
        var description: String = ""
)
