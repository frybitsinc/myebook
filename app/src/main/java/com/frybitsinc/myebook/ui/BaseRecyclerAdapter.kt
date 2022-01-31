package com.frybitsinc.myebook.ui

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.frybitsinc.myebook.R
import com.frybitsinc.myebook.model.BookItem

class BaseRecyclerAdapter(val bookList: List<BookItem>, val context: Context)
    : RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        return BaseViewHolder(LayoutInflater.from(context).inflate(R.layout.book_item, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(bookList[position], context)
    }

    override fun getItemCount(): Int {
        return bookList.count()
    }

    class BaseViewHolder(itemView: View?):RecyclerView.ViewHolder(itemView!!){

        val image = itemView?.findViewById<ImageView>(R.id.image_view_book)
        val title = itemView?.findViewById<TextView>(R.id.title)
        val author = itemView?.findViewById<TextView>(R.id.author)
        val publisher = itemView?.findViewById<TextView>(R.id.publisher)

        fun bind(bookItem:BookItem, context: Context){
            val url = bookItem.image
            if (image != null) {
                Glide.with(context).load(url).into(image)
            }
            title?.text = bookItem.title
            author?.text = bookItem.author
            publisher?.text = bookItem.publisher
        }
    }
}