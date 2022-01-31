package com.frybitsinc.myebook.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.frybitsinc.myebook.R
import com.frybitsinc.myebook.api.BookFetcher
import com.frybitsinc.myebook.model.BookItem

private const val TAG = "HomeFragment"

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var bookRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bookLiveData: LiveData<List<BookItem>> = BookFetcher().fetchBooks()
        bookLiveData.observe(
            this,
            Observer { res -> Log.d(TAG, "response = $res")}
        )
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        bookRecyclerView = view.findViewById(R.id.book_recycler_view)
        bookRecyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }
}